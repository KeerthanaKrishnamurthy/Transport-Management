package com.example.transportmanagement.Repository;

import com.example.transportmanagement.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // save, find, findAll, findByID, saveAll, updateByID
}