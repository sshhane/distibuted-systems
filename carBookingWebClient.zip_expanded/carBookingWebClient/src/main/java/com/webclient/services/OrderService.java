
package com.webclient.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.model.Order;


@Service
public class OrderService {


	public List<Order> getAllOrders() {
		String url = "http://localhost:8080/CarHireRest/webapi/myresource/read";
        Client client = Client.create();
        WebResource webresource = client.resource(url);
                             
        return webresource.get(new GenericType<List<Order>>(){});
    }
	
}

