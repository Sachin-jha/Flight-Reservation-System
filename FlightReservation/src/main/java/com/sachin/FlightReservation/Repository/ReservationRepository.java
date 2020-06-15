package com.sachin.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.FlightReservation.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
