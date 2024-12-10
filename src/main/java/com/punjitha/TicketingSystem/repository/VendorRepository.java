package com.punjitha.TicketingSystem.repository;

import com.punjitha.TicketingSystem.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    void deleteUserById(Long id);
}
