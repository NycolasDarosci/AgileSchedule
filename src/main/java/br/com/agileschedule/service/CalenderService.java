package br.com.agileschedule.service;

import br.com.agileschedule.dto.CalendarRequest;
import br.com.agileschedule.dto.CalendarResponse;
import br.com.agileschedule.entity.Calendar;
import br.com.agileschedule.exception.ResourceNotFoundException;
import br.com.agileschedule.repository.CalendarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalenderService {

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<CalendarResponse> listCalender() {
        List<Calendar> calender = calendarRepository.findAll();
        return calender.stream().map(c -> modelMapper.map(c, CalendarResponse.class)).collect(Collectors.toList());
    }

    public CalendarResponse createEvent(CalendarRequest calendarRequest) {
        Calendar calendar = modelMapper.map(calendarRequest, Calendar.class);
        this.calendarRepository.save(calendar);
        return modelMapper.map(calendar, CalendarResponse.class);
    }

    public CalendarResponse updateEvent(CalendarRequest calendarRequest, Long id) {
        Calendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Num deu bom"));
        modelMapper.map(calendarRequest, calendar);
        this.calendarRepository.save(calendar);
        return modelMapper.map(calendar, CalendarResponse.class);

    }

    public Map<String, Boolean> deleteEvent(Long id) {
        Calendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Num deu bom"));
        this.calendarRepository.delete(calendar);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;

    }

}
