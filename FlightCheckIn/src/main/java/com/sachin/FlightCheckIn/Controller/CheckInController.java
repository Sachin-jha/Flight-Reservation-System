package com.sachin.FlightCheckIn.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sachin.FlightCheckIn.IntegrationLayer.ReservationRestClient;
import com.sachin.FlightCheckIn.IntegrationLayer.DTO.Reservation;
import com.sachin.FlightCheckIn.IntegrationLayer.DTO.UpdateReservationRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restClient;
	
	
	@RequestMapping("/startShowCheckIn")
	public String showCheckIn()
	{
		return "startCheckIn";
	}
	
	@RequestMapping("/checkIn")
	public String displayCheckIn(@RequestParam("reservationId") int id , ModelMap model)
	{
		Reservation findReservation = restClient.findReservation(id);
		model.addAttribute("reservation", findReservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeReservation")
	public String bagCheckIn(@RequestParam("bagsCheckIn") int bag , @RequestParam("reservationId") int resId , ModelMap model)
	{
		UpdateReservationRequest req = new UpdateReservationRequest();
		req.setId(resId);
		req.setCheckedIn(true);
		req.setNumberOfBags(bag);
		
		restClient.updateReservation(req);
		model.addAttribute("successCheckIn", "You are successfully CheckIn with an Reservation ID:-"+req.getId());
		return "checkInSuccess";
	}
}





