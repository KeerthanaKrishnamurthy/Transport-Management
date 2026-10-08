package com.example.transportmanagement.Entity;

import com.example.transportmanagement.Entity.Vehicle;
import jakarta.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "maintenance_event")
public class MaintenanceEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false)
    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public MaintenanceEvent() {
    }

    public MaintenanceEvent(String eventType,
                            LocalDate eventDate,
                            Vehicle vehicle) {
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.vehicle = vehicle;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
