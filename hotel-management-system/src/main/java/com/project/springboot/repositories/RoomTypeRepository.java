package com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.models.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
