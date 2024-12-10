package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.repository.CustomerRepository;
import com.punjitha.TicketingSystem.thread.CustomerThread;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer createCustomer(int customerRetrievalRate) {
        Customer customer = new Customer(customerRetrievalRate);
        return customerRepository.save(customer);
    }

    public void startCustomerThread(Customer customer, TicketPool ticketPool, TicketPoolService ticketPoolService) {
        CustomerThread customerThread = new CustomerThread(ticketPoolService, customer, ticketPool);
        Thread thread = new Thread(customerThread);
        thread.start();
    }
}
