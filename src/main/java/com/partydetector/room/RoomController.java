package com.partydetector.room;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository repo;

    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Room> list() {
        return repo.findAll();
    }
}