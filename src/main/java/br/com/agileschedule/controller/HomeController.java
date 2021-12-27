package br.com.agileschedule.controller;

import br.com.agileschedule.dto.CalendarRequest;
import br.com.agileschedule.dto.CalendarResponse;
import br.com.agileschedule.entity.Calendar;
import br.com.agileschedule.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller("/")
public class HomeController {

    @Autowired
    CalenderService calenderService;

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/listAllCalendar")
    public ResponseEntity<List<CalendarResponse>> listCalender() {
        List<CalendarResponse> calendarResponse = calenderService.listCalender();
        return ResponseEntity.ok(calendarResponse);
    }

    @PostMapping("/newCalendar")
    public ResponseEntity<CalendarResponse> criarEvento(@RequestBody @Valid CalendarRequest calendarRequest, UriComponentsBuilder builder) {
        CalendarResponse calendarResponse = calenderService.createEvent(calendarRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(calendarResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(calendarResponse);
    }

    @PutMapping("/calendar/{id}")
    public ResponseEntity<CalendarResponse> updateEvent(@PathVariable Long id, @RequestBody @Valid CalendarRequest calendarRequest) {
        CalendarResponse calendarResponse = calenderService.updateEvent(calendarRequest, id);
        return ResponseEntity.ok(calendarResponse);
    }

    @DeleteMapping("/calendar/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        calenderService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

}
