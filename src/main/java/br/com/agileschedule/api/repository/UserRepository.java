
package br.com.agileschedule.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agileschedule.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
