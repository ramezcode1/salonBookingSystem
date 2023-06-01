package com.app.salonbooking.view;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingView {
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String comments;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerPhoneNumber;
    @NotBlank
    private String customerEmail;
    private Integer serviceId;
    private Integer barberId;
}
