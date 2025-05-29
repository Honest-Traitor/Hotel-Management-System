package com.project.springboot.services;

import com.project.springboot.exceptions.ResourceNotFoundException;
import com.project.springboot.models.Room;
import com.project.springboot.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImplementation implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomById(String id) {
        Long idLong = Long.parseUnsignedLong(id);
        Room room = roomRepository.findById(idLong)
                .orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
        return room;
    }

    @Override
    public Room updateRoomById(Room roomDetails, String id) {
        Room room = roomRepository.findById(Long.parseUnsignedLong(id))
                .orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
        room.setRoomNo(roomDetails.getRoomNo());
        room.setRoomTypeCode(roomDetails.getRoomTypeCode());
        room.setFloor(roomDetails.getFloor());
        room.setFrontFace(roomDetails.getFrontFace());
        room.setAc(roomDetails.getAc());
        room.setPrice(roomDetails.getPrice());

        Room updatedRoom = roomRepository.save(room);
        return updatedRoom;
    }

    @Override
    public Map<String, Boolean> deleteRoomeById(String id) {
        Long idLong = Long.parseUnsignedLong(id);
        Room room = roomRepository.findById(idLong)
                .orElseThrow(()-> new ResourceNotFoundException("Room doesn't exist with id [" + id + "]"));
        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
