package br.com.agileschedule.repository;

import br.com.agileschedule.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CalendarRepository extends JpaRepository<Calendar, String>{

    Optional<Calendar> findById(Long id);


}
