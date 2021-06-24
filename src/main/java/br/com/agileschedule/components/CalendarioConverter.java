package br.com.agileschedule.Components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.agileschedule.DTO.CalendarioDTO;
import br.com.agileschedule.Entity.Calendario;
import br.com.agileschedule.Form.CalendarioForm;

@Component
public class CalendarioConverter {

	// Convertendo um CalendarioForm em um model Calendario
	public Calendario toCalendario(CalendarioForm calendarForm) {
		return new Calendario(calendarForm.getDiaInicial(), calendarForm.getDiaFinal(), calendarForm.getHrInicial(),
				calendarForm.getHrFinal(), calendarForm.getDescricao());
	}

	// Convertendo um CalendarioDTO em um model Calendario
	public Calendario toCalendario(CalendarioDTO calendarioDTO) {
		return new Calendario(calendarioDTO.getDiaInicial(), calendarioDTO.getDiaFinal(), calendarioDTO.getHrInicial(),
				calendarioDTO.getHrFinal(), calendarioDTO.getDescricao());
	}

	// Convertendo um model Calendario em um CalendarioDTO
	public CalendarioDTO toCalendarioDTO(Calendario calendario) {
		return new CalendarioDTO(calendario.getDiaInicial(), calendario.getDiaFinal(), calendario.getHrInicial(),
				calendario.getHrFinal(), calendario.getDescricao());
	}

	// Convertendo uma list de model Calendario em uma List de CalendarioDTO
	public List<CalendarioDTO> toListCalendarioDTO(List<Calendario> calen) {

		List<CalendarioDTO> calendariosDTO = new ArrayList<CalendarioDTO>();
		for (Calendario calendario : calen) {
			CalendarioDTO calenDTO = new CalendarioDTO(calendario.getDiaInicial(), calendario.getDiaFinal(),
					calendario.getHrInicial(), calendario.getHrFinal(), calendario.getDescricao());
			calendariosDTO.add(calenDTO);
		}
		return calendariosDTO;
	}
}
