package com.partydetector.alert;

import com.partydetector.alert.dto.CreateAlertRequest;
import com.partydetector.room.Room;
import com.partydetector.room.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertRepository alertRepo;
    private final RoomRepository roomRepo;

    public AlertController(AlertRepository alertRepo, RoomRepository roomRepo) {
        this.alertRepo = alertRepo;
        this.roomRepo = roomRepo;
    }

    @GetMapping
    public Alert create(@RequestBody @Valid CreateAlertRequest req) {
        // save alert
        Alert a = new Alert();
        a.setDeviceId(req.deviceId);
        a.setLocation(req.location);
        a.setNoiseLevel(req.noiseLevel);
        a.setDuration(req.duration);
        a.setStatus(Alert.Status.NEW);
        Alert saved = alertRepo.save(a);

        // update room (or create if missing)
        Room room = roomRepo.findByDeviceId(req.deviceId).orElseGet(() -> {
            Room r = new Room();
            r.setDeviceId(req.deviceId);
            r.setName(req.location);
            r.setFloor(null);
            return r;
        });
        room.setCurrentNoise(req.noiseLevel);
        room.setLastUpdate(Instant.now());
        roomRepo.save(room);

        return saved;
    }

    @GetMapping("/latest")
    public List<Alert> latest() {
        return alertRepo.findTop50ByOrderByCreatedAtDesc();
    }

    @PostMapping("/{id}/ack")
    public Alert ack(@PathVariable String id) {
        Alert a = alertRepo.findById(id).orElseThrow();
        a.setStatus(Alert.Status.ACK);
        return alertRepo.save(a);
    }
}