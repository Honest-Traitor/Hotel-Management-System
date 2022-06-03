package com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
