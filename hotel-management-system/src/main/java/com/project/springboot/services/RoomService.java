package com.project.springboot.services;

import com.project.springboot.models.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface RoomService {

    List<Room> getAllRooms();
    Room createRoom(Room room);
    Room getRoomById(String id);
    Room updateRoomById(Room roomDetails, String id);
    Map<String,Boolean> deleteRoomeById(String id);
}
