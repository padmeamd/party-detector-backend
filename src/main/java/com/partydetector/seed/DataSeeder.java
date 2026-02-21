package com.partydetector.seed;

import com.partydetector.room.Room;
import com.partydetector.room.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoomRepository repo;

    public DataSeeder(RoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) return;

        Room r1 = new Room();
        r1.setName("Dorm A - Floor 2 Corridor");
        r1.setFloor(2);
        r1.setDeviceId("ESP32-01");
        r1.setCurrentNoise(0);
        repo.save(r1);

        Room r2 = new Room();
        r2.setName("Room B204");
        r2.setFloor(2);
        r2.setDeviceId("ESP32-02");
        r2.setCurrentNoise(0);
        repo.save(r2);
    }
}