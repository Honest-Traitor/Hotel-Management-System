package com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
