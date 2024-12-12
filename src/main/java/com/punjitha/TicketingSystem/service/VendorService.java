package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.repository.VendorRepository;
import com.punjitha.TicketingSystem.thread.VendorThread;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final LoggerService loggerService;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteUserById(id);
    }

    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
