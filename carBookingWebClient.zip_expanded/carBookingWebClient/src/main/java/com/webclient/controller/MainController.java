package com.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.webclient.services.OrderService;

import ie.gmit.sw.model.Order;


@Controller
public class MainController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public String viewAllVehicles(Model model) throws IOException, JAXBException {
//		this.vehicleService = new VehicleService();
		
		List<Order> orders = orderService.getAllOrders();
		
		
		model.addAttribute("orders", orders);
		
		return "viewRental";
	}

}

