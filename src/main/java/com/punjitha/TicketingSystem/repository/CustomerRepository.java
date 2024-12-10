package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void deleteUserById(Long id);
}
