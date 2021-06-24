package br.com.agileschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.entity.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

}
