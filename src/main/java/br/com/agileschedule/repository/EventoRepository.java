package br.com.agileschedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByUserId(Long id);
}
