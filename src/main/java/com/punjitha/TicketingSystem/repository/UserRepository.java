package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

}
