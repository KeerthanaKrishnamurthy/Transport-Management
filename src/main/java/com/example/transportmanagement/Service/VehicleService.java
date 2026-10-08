package com.example.transportmanagement.Service;


import com.example.transportmanagement.Entity.Vehicle;
import com.example.transportmanagement.Repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle); // JPA Repository
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Vehicle not found"
            );
        }

        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {

        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vehicle not found"
                ));

        existingVehicle.setMake(updatedVehicle.getMake());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setYear(updatedVehicle.getYear());
        existingVehicle.setColor(updatedVehicle.getColor());
        existingVehicle.setRegistrationNumber(
                updatedVehicle.getRegistrationNumber()
        );

        return vehicleRepository.save(existingVehicle);
    }

    public Vehicle patchVehicle(Long id, Map<String, Object> updates) {

        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vehicle not found"
                ));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            String field = entry.getKey();
            Object value = entry.getValue();

            switch (field) {
                case "make":
                    existingVehicle.setMake((String) value);
                    break;

                case "model":
                    existingVehicle.setModel((String) value);
                    break;

                case "year":
                    existingVehicle.setYear(((Number) value).intValue());
                    break;

                case "color":
                    existingVehicle.setColor((String) value);
                    break;

                case "registrationNumber":
                    existingVehicle.setRegistrationNumber((String) value);
                    break;

                default:
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Invalid field: " + field
                    );
            }
        }

        return vehicleRepository.save(existingVehicle);
    }
}