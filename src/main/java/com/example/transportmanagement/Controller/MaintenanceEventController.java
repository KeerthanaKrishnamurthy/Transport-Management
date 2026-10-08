package com.example.transportmanagement.Controller;

import com.example.transportmanagement.Entity.MaintenanceEvent;
import com.example.transportmanagement.Service.MaintenanceEventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")

public class MaintenanceEventController {

    private final MaintenanceEventService maintenanceEventService;

    public MaintenanceEventController(MaintenanceEventService maintenanceEventService) {
        this.maintenanceEventService = maintenanceEventService;
    }

    @PostMapping
    public MaintenanceEvent addMaintenanceEvent(@RequestBody MaintenanceEvent maintenanceEvent) {
        return maintenanceEventService.addMaintenanceEvent(maintenanceEvent);
    }
}
