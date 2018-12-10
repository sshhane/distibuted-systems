package com.webclient.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webclient.http.httpRequests;

import ie.gmit.sw.model.Order;

@Controller
public class UpdateController {

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/addRental", method = RequestMethod.GET)
	public String addRentalGET(Model model) {
		Order Order = new Order();
		model.addAttribute("Order", Order);
		return "addRental";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/addRental", method = RequestMethod.POST)
	public String addRentalPOST(@Valid @ModelAttribute("Order") Order Order, Model model) {

		return "index";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/viewRental", method = RequestMethod.GET)
	public String viewRentalGET(Model model) {
		Order Order = new Order();
		model.addAttribute("Order", Order);
		return "viewRental";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/viewRental", method = RequestMethod.POST)
	public String viewRentalPOST(@Valid @ModelAttribute("rentals") Order Order, Model model) {

		return "index";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/deleteRental", method = RequestMethod.GET)
	public String deleteRentalGET(Model model) {
		Order Order = new Order();
		model.addAttribute("Order", Order);
		return "deleteRental";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/deleteRental", method = RequestMethod.POST)
	public String deleteRentalPOST(@Valid @ModelAttribute("rentals") Order Order, Model model) {

		return "index";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/updateRental", method = RequestMethod.GET)
	public String updateRentalGET(Model model) {
		Order Order = new Order();
		model.addAttribute("Order", Order);
		return "updateRental";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/updateRental", method = RequestMethod.POST)
	public String updateRentalPOST(@Valid @ModelAttribute("Order") Order Order, Model model) {
		
		new httpRequests().updateRental(Order);
		
		return "index";
	}
}
