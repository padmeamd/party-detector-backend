package com.partydetector.room;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    private Integer floor;

    @Column(nullable = false, unique = true)
    private String deviceId;

    private Integer currentNoise;
    private Instant lastUpdate;

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public Integer getCurrentNoise() { return currentNoise; }
    public void setCurrentNoise(Integer currentNoise) { this.currentNoise = currentNoise; }

    public Instant getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Instant lastUpdate) { this.lastUpdate = lastUpdate; }
}