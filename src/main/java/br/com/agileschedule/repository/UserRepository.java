package br.com.agileschedule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
