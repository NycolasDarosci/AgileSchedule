package br.com.agileschedule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByDescricao(String descricao);
    
}
