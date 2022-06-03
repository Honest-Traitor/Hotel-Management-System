package com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.models.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
