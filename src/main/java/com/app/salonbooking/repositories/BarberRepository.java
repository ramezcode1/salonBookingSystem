package com.app.salonbooking.repositories;

import com.app.salonbooking.models.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Integer> {
}
