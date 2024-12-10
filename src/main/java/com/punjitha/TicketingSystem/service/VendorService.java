package com.punjitha.TicketingSystem.service;

import com.punjitha.TicketingSystem.model.TicketPool;
import com.punjitha.TicketingSystem.model.Vendor;
import com.punjitha.TicketingSystem.repository.VendorRepository;
import com.punjitha.TicketingSystem.thread.VendorThread;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    @Transactional
    public Vendor createVendor(int TotalTickets, int TicketReleaseRate) {
        Vendor vendor = new Vendor(TotalTickets, TicketReleaseRate);
        return vendorRepository.save(vendor);
    }

    public void startVendorThread(Vendor vendor, TicketPool ticketPool, TicketPoolService ticketPoolService) {
        VendorThread vendorThread = new VendorThread(ticketPoolService, vendor, ticketPool);
        Thread thread = new Thread(vendorThread);
        thread.start();
    }
}
