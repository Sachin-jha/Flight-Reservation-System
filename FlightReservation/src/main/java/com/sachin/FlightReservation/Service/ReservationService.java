package com.sachin.FlightReservation.Service;

import com.sachin.FlightReservation.DTO.ReservationRequest;
import com.sachin.FlightReservation.Model.Reservation;

public interface ReservationService {
	
	public Reservation flightBooking(ReservationRequest request);

}
