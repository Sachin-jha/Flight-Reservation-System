package com.sachin.FlightCheckIn.IntegrationLayer;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sachin.FlightCheckIn.IntegrationLayer.DTO.Reservation;
import com.sachin.FlightCheckIn.IntegrationLayer.DTO.UpdateReservationRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Override
	public Reservation findReservation(int id) {
		
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject("http://localhost:8080/FlightReservation/reservations/"+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(UpdateReservationRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject("http://localhost:8080/FlightReservation/reservations/", request, Reservation.class);
		return reservation;
	}

}
