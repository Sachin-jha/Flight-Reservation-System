package com.sachin.FlightCheckIn.IntegrationLayer;

import com.sachin.FlightCheckIn.IntegrationLayer.DTO.Reservation;
import com.sachin.FlightCheckIn.IntegrationLayer.DTO.UpdateReservationRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(int id);
	public Reservation updateReservation(UpdateReservationRequest request);

}
