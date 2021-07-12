package br.com.agileschedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.agileschedule.dto.EventoDTO;
import br.com.agileschedule.form.EventoForm;
import br.com.agileschedule.model.Evento;
import br.com.agileschedule.model.User;
import br.com.agileschedule.repository.EventoRepository;
import javassist.NotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoR;

	public List<EventoDTO> listEventoService() throws NotFoundException {
		//Pegando usuário logado
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = new User();
		user.setId(1L);

		//Buscando o calendário deste usuário por seu id
		List<Evento> evento = eventoR.findByUserId(user.getId());

		//Convertendo a lista de eventos para uma lista DTO
		return Evento.toListDTO(evento);
	}


	public EventoDTO newEventoService(EventoForm eventoForm) throws NotFoundException {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//User user = new User();
		//user.setId(1L);

		Evento evento = eventoForm.toEvento();
		//Definindo usuário que criou o evento como o usuário logado
		evento.setUser(user);
		//Salvando evento no banco
		eventoR.save(evento);

		return evento.toDTO();
	}


	public EventoDTO updateEventoService(Long id, EventoForm eventoForm) throws NotFoundException {
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		user.setId(1L);

		// Encontra o evento no banco de dados
		Evento evento = eventoR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));
		
		//Verifica se o usuário logado é o mesmo usuário que quer atualizar o evento
		if(evento.getUser().equals(user))
		{
			//Atualizando o evento com os dados passados no form
			evento.setDescricao(eventoForm.getDescricao());
			evento.setDiaInicial(eventoForm.getDiaInicial());
			evento.setDiaFinal(eventoForm.getDiaFinal());
			evento.setHoraInicial(eventoForm.getHoraInicial());
			evento.setHoraFinal(eventoForm.getHoraFinal());
			return evento.toDTO();
		}
		//Caso não seja, é jogada uma exception
		throw new AccessDeniedException("Usuário inválido!");
	}


	public void deleteEventoService(Long id) throws NotFoundException {
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = new User();
		user.setId(1L);	

		Evento evento = eventoR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));
		
		if(evento.getUser().equals(user)) {
			eventoR.delete(evento);
		}
		throw new AccessDeniedException("Usuário inválido!");
	}
}
