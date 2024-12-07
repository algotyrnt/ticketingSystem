package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.User;
import com.punjitha.TicketingSystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User FindUserById(Long id) {
        return (User) userRepository.findUserById(id).orElseThrow( () -> new RuntimeException("User with id " + id + " not found"));
    }

    public void DeleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
