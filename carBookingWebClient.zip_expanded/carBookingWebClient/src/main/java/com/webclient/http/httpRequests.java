package com.webclient.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import ie.gmit.sw.model.Order;

public class httpRequests {

	private Order Order;
	private String resourceBaseURL = "http://localhost:8080/CarHireRest/webapi/myresource";
	private URL url;
	private HttpURLConnection con;
	private String resultInXml = "";

	// Get all Rentals
	public Order viewRental(Order Order) {
		return makeGetRequest();
	}

	// Create Account
	public void updateRental(Order Order) {
		makePutRequest(Order);
	}

	// Get all cars
	public void deleteRental(String acc) {
		makeDeleteRequest(acc);
	}

	// Create Rental
	public void createRental(Order Order) {
		makePostRequest(Order);
	}

	// HTTP method for deleting a Rental
	private void makeDeleteRequest(String value) {

		try {
			// Making connection
			url = new URL(resourceBaseURL + "delete" + value);
			con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setInstanceFollowRedirects(false);
			// Setting method a delete
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("charset", "utf-8");
			con.setUseCaches(false);

			con.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
		}
	}

	// HTTP method for sending a PUT request
	private void makePutRequest(Order Order) {		
		// Marshaling before sending
		String str = getOrderAsXML(Order);

		try {
			
			// Making connection
			url = new URL(resourceBaseURL + "update");
			con = (HttpURLConnection) url.openConnection();
			// Setting the request to PUT
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

			con.disconnect();

		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
			
		}
	}

	// HTTP method for making a GET request
	private Order makeGetRequest() {

		Order Order = new Order();

		// try to create a connection and request XML format
		try {
			// Making connection
			url = new URL(resourceBaseURL + "read/0");
			con = (HttpURLConnection) url.openConnection();
			// Setting the request to GET
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/xml");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			resultInXml = br.lines().collect(Collectors.joining());
			con.disconnect();

			// Changing the returned response from xml into a rental object
			Order = getPoFromXml(resultInXml);

			return Order;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	// HTTP method for making a POST request
	private void makePostRequest(Order Order) {

		// changing the to xml
		String str = getOrderAsXML(Order);

		try {
			// Making the connection
			url = new URL(resourceBaseURL + "insertRental");
			con = (HttpURLConnection) url.openConnection();
			// Setting the requested type to POST
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	// Method for converting xml to a POJO
	private Order getPoFromXml(String input) {
		// Unmarshal the PurchaseOrder from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller um1;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			um1 = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<Order> poElement1 = um1.unmarshal(source1, Order.class);
			this.Order = (Order) poElement1.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.Order;
	}

	// Method for converting a POJO to xml
	private String getOrderAsXML(Order po) {
		// Marshal the PurchaseOrder into XML
		StringWriter sw = new StringWriter();
		Marshaller m;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(po, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}

}
