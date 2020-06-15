package com.sachin.FlightReservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sachin.FlightReservation.Model.User;
import com.sachin.FlightReservation.Repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/")
	public String signUpPage()
	{
		return "SignUp";
	}

	@RequestMapping(value = "/SignUpPage" , method = RequestMethod.POST)
	public String signUp(@ModelAttribute("User") User user)
	{
		repository.save(user);		
		return "/login/Login";
	}
	
	@RequestMapping("/login")
	public String getLoginPage()
	{
		return "/login/Login";
	}
	
	@RequestMapping(value = "/LoginPage" , method = RequestMethod.POST)
	public String loginPage(@RequestParam("email") String email , @RequestParam("password") String password , ModelMap model)
	{		
		User u = repository.findByEmail(email);
		if(u.getEmail().equals(email) && u.getPassword().equals(password))
			return "Flight";			
		else
			model.addAttribute("wrong", "Invalid Credentials!!");
		
		return "/login/Login";
	}	
		
}
