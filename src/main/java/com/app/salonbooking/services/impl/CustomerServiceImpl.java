package com.app.salonbooking.services.impl;

import com.app.salonbooking.models.Customer;
import com.app.salonbooking.repositories.CustomerRepository;
import com.app.salonbooking.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
