package com.app.salonbooking.services.impl;

import com.app.salonbooking.models.Barber;
import com.app.salonbooking.models.Booking;
import com.app.salonbooking.models.Customer;
import com.app.salonbooking.models.ServiceItem;
import com.app.salonbooking.repositories.BookingRepository;
import com.app.salonbooking.services.BarberService;
import com.app.salonbooking.services.BookingService;
import com.app.salonbooking.services.CustomerService;
import com.app.salonbooking.services.ServiceItemService;
import com.app.salonbooking.view.BookingView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ServiceItemService serviceItemService;
    private final BarberService barberService;
    private final CustomerService customerService;

    private final ModelMapper mapper;

    @Value("${app.service.opening-hour}")
    private String openingHour;
    @Value("${app.service.closing-hour}")
    private String closingHour;

    @Value("${app.service.duration}")
    private String durationTime;

    @Override
    public List<LocalTime> getAvailableBookingByDateAndBarber(String dateString, Integer barberId) {
        List<LocalTime> availableTimeList = new ArrayList<>();
        LocalDate bookingDate = dateString == null ? LocalDate.now() : LocalDate.parse(dateString);
        LocalTime startTime = LocalTime.parse(openingHour);
        LocalTime endTime = LocalTime.parse(closingHour);
        long duration = Long.parseLong(durationTime);

        LocalTime tempTime = startTime;
        while (endTime.compareTo(tempTime) != 0) {
            List<Booking> bookingList = bookingRepository
                    .findByBookingDateAndStartTimeAndBarberId(bookingDate, tempTime, barberId);
            if(bookingList.isEmpty()) {
                availableTimeList.add(tempTime);
            }
            tempTime = tempTime.plusMinutes(duration);
        }
        return availableTimeList;
    }

    @Override
    public void saveBooking(BookingView bookingView) {
        Customer customer = Customer.builder().
                name(bookingView.getCustomerName())
                .phoneNumber(bookingView.getCustomerPhoneNumber())
                .email(bookingView.getCustomerEmail())
                .build();
        customer = customerService.save(customer);
        Barber barber = barberService.getBarberById(bookingView.getBarberId());
        ServiceItem serviceItem = serviceItemService.getServiceById(bookingView.getServiceId());

        Booking booking = Booking.builder()
                .bookingDate(bookingView.getBookingDate())
                .startTime(bookingView.getStartTime())
                .comments(bookingView.getComments())
                .barber(barber)
                .serviceItem(serviceItem)
                .customer(customer)
                .build();
        bookingRepository.save(booking);
    }
}
