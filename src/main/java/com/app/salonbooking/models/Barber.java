package com.app.salonbooking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "barbers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    //Join with bookings table
    @OneToMany(mappedBy = "barber", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Booking> bookings;

    //Join with services table
    @ManyToMany(mappedBy = "barbers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ServiceItem> serviceItems;
}
