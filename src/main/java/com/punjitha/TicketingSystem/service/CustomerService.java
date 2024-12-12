package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.repository.CustomerRepository;
import com.punjitha.TicketingSystem.thread.CustomerThread;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final LoggerService loggerService;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteUserById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
