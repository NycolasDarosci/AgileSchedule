package br.com.agileschedule.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.api.model.TipoUser;

public interface TipoUserRepository extends JpaRepository<TipoUser, Long> {

	Optional<TipoUser> findByDescricao(String string);

    
}
