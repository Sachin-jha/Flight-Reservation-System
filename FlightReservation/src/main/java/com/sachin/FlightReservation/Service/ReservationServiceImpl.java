package com.sachin.FlightReservation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sachin.FlightReservation.DTO.ReservationRequest;
import com.sachin.FlightReservation.Model.Flight;
import com.sachin.FlightReservation.Model.Passenger;
import com.sachin.FlightReservation.Model.Reservation;
import com.sachin.FlightReservation.Repository.FlightRepository;
import com.sachin.FlightReservation.Repository.PassengerRepository;
import com.sachin.FlightReservation.Repository.ReservationRepository;
import com.sachin.FlightReservation.UtilityLayer.PdfGenerator;

@Service
@CrossOrigin
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdf;

	@Override
	@Transactional
	public Reservation flightBooking(ReservationRequest request) {
		
		int flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassenggerFirstName());
		passenger.setLastName(request.getPassenggerLastName());
		passenger.setMiddleName(request.getPassenggerMiddleName());
		passenger.setEmail(request.getPassenggerEmail());
		passenger.setPhone(request.getPassenggerPhone());		
		Passenger passengerSaved = passengerRepository.save(passenger);
		
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passengerSaved);
		reservation.setCheckedIn(false);
		Reservation reservationSaved = reservationRepository.save(reservation);
		
		String path = "C:\\Users\\Sachin\\Downloads\\reservationID_"+reservation.getId()+".pdf";
		pdf.generatePDF(reservationSaved, path);
		
		return reservationSaved;
	}

}
