package com.sachin.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.FlightReservation.Model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
