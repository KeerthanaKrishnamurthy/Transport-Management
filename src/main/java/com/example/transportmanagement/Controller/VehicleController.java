package com.example.transportmanagement.Controller;

import com.example.transportmanagement.Entity.Vehicle;
import com.example.transportmanagement.Service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles") // API Endpoint
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle) {

        return vehicleService.updateVehicle(id, vehicle);
    }

    @PatchMapping("/{id}")
    public Vehicle patchVehicle(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return vehicleService.patchVehicle(id, updates);
    }
}