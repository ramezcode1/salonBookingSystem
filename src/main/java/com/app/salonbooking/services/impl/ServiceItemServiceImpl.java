package com.app.salonbooking.services.impl;

import com.app.salonbooking.exception.ServiceItemNotFoundException;
import com.app.salonbooking.models.Barber;
import com.app.salonbooking.models.ServiceItem;
import com.app.salonbooking.repositories.ServiceItemRepository;
import com.app.salonbooking.services.ServiceItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceItemServiceImpl implements ServiceItemService {

    private final ServiceItemRepository serviceItemRepository;

    @Override
    public List<ServiceItem> getAllServiceItems() {
        return serviceItemRepository.findAll();
    }

    @Override
    public List<Barber> getAllEmployeeForService(Integer serviceId) {
        ServiceItem serviceItem = serviceItemRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceItemNotFoundException("service not Found"));
        return serviceItem.getBarbers();
    }

    @Override
    public ServiceItem getServiceById(Integer serviceId) {
        return serviceItemRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceItemNotFoundException("service not Found"));
    }
}
