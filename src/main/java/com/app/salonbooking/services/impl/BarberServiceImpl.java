package com.app.salonbooking.services.impl;

import com.app.salonbooking.models.Barber;
import com.app.salonbooking.repositories.BarberRepository;
import com.app.salonbooking.services.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Override
    public Barber getBarberById(Integer barberId) {
        return barberRepository.findById(barberId).orElse(null);
    }
}
