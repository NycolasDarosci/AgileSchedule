package br.com.agileschedule.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.api.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByUserId(Long id);
}
