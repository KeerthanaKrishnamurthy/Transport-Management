package com.example.transportmanagement.Repository;

import com.example.transportmanagement.Entity.MaintenanceEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceEventRepository extends JpaRepository<MaintenanceEvent, Long> {
}
