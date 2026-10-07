package com.example.transportmanagement.Service;

import com.example.transportmanagement.Entity.MaintenanceEvent;
import com.example.transportmanagement.Repository.MaintenanceEventRepository;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceEventService {

    private final MaintenanceEventRepository maintenanceEventRepository;

    public MaintenanceEventService(MaintenanceEventRepository maintenanceEventRepository) {
        this.maintenanceEventRepository = maintenanceEventRepository;
    }

    public MaintenanceEvent addMaintenanceEvent(MaintenanceEvent maintenanceEvent) {
        return maintenanceEventRepository.save(maintenanceEvent);
    }

}


