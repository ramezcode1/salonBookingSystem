package com.app.salonbooking.controllers;

import com.app.salonbooking.services.BarberService;
import com.app.salonbooking.services.BookingService;
import com.app.salonbooking.services.ServiceItemService;
import com.app.salonbooking.view.BookingView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    private final ServiceItemService itemService;

    private final BarberService barberService;

    @GetMapping("/service")
    public String selectService(Model model) {
        model.addAttribute("services", itemService.getAllServiceItems());
        return "bookings/select_service";
    }

    @GetMapping("/employee")
    public String selectEmployeeForService(@RequestParam Integer serviceId, Model model) {
        model.addAttribute("serviceId", serviceId);
        model.addAttribute("barbers", itemService.getAllEmployeeForService(serviceId));
        return "bookings/select_employee";
    }

    @GetMapping("/appointment")
    public String selectAvailableBooking(@RequestParam Integer serviceId, @RequestParam Integer barberId,
                                         @RequestParam(required = false) String dateString,
                                         Model model) {
        List<LocalTime> availableTimeList = bookingService.getAvailableBookingByDateAndBarber(dateString, barberId);

        model.addAttribute("service", itemService.getServiceById(serviceId));
        model.addAttribute("barberId", barberId);
        model.addAttribute("availableTimeList", availableTimeList);
        return "bookings/select_date_time";
    }

    @GetMapping("/customer_info")
    public String selectCustomerInfo(@RequestParam Integer serviceId, @RequestParam Integer barberId,
                                     @RequestParam(required = false) String dateString,
                                     @RequestParam String timeString, Model model) {
        model.addAttribute("service", itemService.getServiceById(serviceId));
        model.addAttribute("barber", barberService.getBarberById(barberId));
        model.addAttribute("dateString", dateString);
        model.addAttribute("timeString", timeString);
        model.addAttribute("bookingView", new BookingView());
        return "bookings/customer_form";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("bookingView") @Valid BookingView bookingView, BindingResult result,
                              Model model) {
        model.addAttribute("service", itemService.getServiceById(bookingView.getServiceId()));
        model.addAttribute("barber", barberService.getBarberById(bookingView.getBarberId()));
        model.addAttribute("dateString", bookingView.getBookingDate());
        model.addAttribute("timeString", bookingView.getStartTime());
        if (result.hasErrors()) {
            return "bookings/customer_form";
        }

        bookingService.saveBooking(bookingView);
        return "bookings/book_confirm";
    }
}
