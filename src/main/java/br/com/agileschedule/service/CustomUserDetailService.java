package br.com.agileschedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.agileschedule.entity.User;
import br.com.agileschedule.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não localizado");
        }
        return new CustomUserDetail(user);
    }
}
