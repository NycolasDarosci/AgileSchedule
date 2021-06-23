package br.com.agileschedule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.Entity.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Long>{

}
