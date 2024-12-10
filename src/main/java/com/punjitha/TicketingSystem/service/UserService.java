package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Customer;
import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void DeleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

    public Vendor createVendor(int ticketReleaseRate) {
        Vendor vendor = new Vendor(ticketReleaseRate);
        return (Vendor) userRepository.save(vendor);
    }

    public Customer createCustomer(int customerRetrievalRate) {
        Customer customer = new Customer(customerRetrievalRate);
        return (Customer) userRepository.save(customer);
    }
}