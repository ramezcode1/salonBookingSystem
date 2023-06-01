package com.app.salonbooking.services;

import com.app.salonbooking.models.Barber;
import com.app.salonbooking.models.ServiceItem;

import java.util.List;

public interface ServiceItemService {
    List<ServiceItem> getAllServiceItems();
    List<Barber> getAllEmployeeForService(Integer serviceId);

    ServiceItem getServiceById(Integer serviceId);
}
