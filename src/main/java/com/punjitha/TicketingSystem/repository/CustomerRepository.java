package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
