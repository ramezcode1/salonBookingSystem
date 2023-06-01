package com.app.salonbooking.repositories;

import com.app.salonbooking.models.Barber;
import com.app.salonbooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingDateAndStartTimeAndBarberId(LocalDate bookingDate,
                                                         LocalTime startTime,
                                                         Integer barberId);
}
