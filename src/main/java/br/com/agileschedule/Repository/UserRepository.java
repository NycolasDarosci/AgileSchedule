package br.com.agileschedule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
