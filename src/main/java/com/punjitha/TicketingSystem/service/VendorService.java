package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VendorService {

    public final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
