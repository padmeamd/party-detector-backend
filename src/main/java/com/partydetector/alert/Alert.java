package com.partydetector.alert;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "alerts")
public class Alert {

    public enum Status { NEW, ACK }

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer noiseLevel;

    private Integer duration; // seconds above threshold

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.NEW;

    public String getId() { return id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getNoiseLevel() { return noiseLevel; }
    public void setNoiseLevel(Integer noiseLevel) { this.noiseLevel = noiseLevel; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Instant getCreatedAt() { return createdAt; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}