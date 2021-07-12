package br.com.agileschedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.agileschedule.dto.EventoDTO;
import br.com.agileschedule.form.EventoForm;
import br.com.agileschedule.model.Evento;
import br.com.agileschedule.model.User;
import br.com.agileschedule.repository.EventoRepository;
import br.com.agileschedule.repository.UserRepository;
import javassist.NotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoR;

	@Autowired
	private UserRepository userR;

	public List<EventoDTO> listEventoService() throws NotFoundException {
		//Pegando usuário logado
		CustomUserDetails userD = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		//Buscando o calendário deste usuário por seu id
		Optional<User> user = userR.findByEmail(userD.getUsername());
		List<Evento> evento = eventoR.findByUserId(user.get().getId());

		//Convertendo a lista de eventos para uma lista DTO
		return Evento.toListDTO(evento);
	}


	public EventoDTO newEventoService(EventoForm eventoForm) throws NotFoundException {

		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Evento evento = eventoForm.toEvento();
		Optional<User> user = userR.findByEmail(userDetails.getUsername());
		//Definindo usuário que criou o evento como o usuário logado
		evento.setUser(user.get());
		//Salvando evento no banco
		eventoR.save(evento);

		return evento.toDTO();
	}


	public EventoDTO updateEventoService(Long id, EventoForm eventoForm) throws NotFoundException {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// Encontra o evento no banco de dados
		Evento evento = eventoR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));
		
		//Verifica se o usuário logado é o mesmo usuário que quer atualizar o evento
		if(evento.getUser().equals(user))
		{
			//Atualizando o evento com os dados passados no form
			evento.setTitulo(eventoForm.getTitulo());
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
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Evento evento = eventoR.findById(id).orElseThrow(() -> new NotFoundException("Evento não encontrado!"));
		
		if(evento.getUser().equals(user)) {
			eventoR.delete(evento);
		}
		throw new AccessDeniedException("Usuário inválido!");
	}
}
