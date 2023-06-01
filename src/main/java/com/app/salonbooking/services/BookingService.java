package com.app.salonbooking.services;

import com.app.salonbooking.view.BookingView;

import java.time.LocalTime;
import java.util.List;

public interface BookingService {
    List<LocalTime> getAvailableBookingByDateAndBarber(String dateString, Integer barberId);

    void saveBooking(BookingView bookingView);
}
