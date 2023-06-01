package com.app.salonbooking.repositories;

import com.app.salonbooking.models.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Integer> {
}
