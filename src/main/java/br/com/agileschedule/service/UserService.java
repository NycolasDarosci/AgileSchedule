package br.com.agileschedule.service;

import br.com.agileschedule.dto.UserRequest;
import br.com.agileschedule.dto.UserResponse;
import br.com.agileschedule.entity.User;
import br.com.agileschedule.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public UserResponse newUser(UserRequest userRequest){
        User user = modelMapper.map(userRequest, User.class);
        this.userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }
}
