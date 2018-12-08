package ie.gmit.sw.CarHireRest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import ie.gmit.sw.model.Order;

public class CarServiceImpl extends UnicastRemoteObject implements CarHireService{

	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private java.sql.Statement statement;

	protected CarServiceImpl() throws Exception {
		super();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/car_hire?useSSL=false", "root", "root");
		}

	@Override
	public String Create(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> Read() throws Exception {
		System.out.println("in read");
		
		statement = connection.createStatement();
		
		List<Order> list = new ArrayList<Order>();
		
		
		String select = "select * from rentals";
		
		ResultSet reset = statement.executeQuery(select);
		
		while (reset.next()) {
			int rentalId = reset.getInt("rentalId");
//			int customerId = reset.getInt("customerId");
			int carId = reset.getInt("carId");
			
			Order o = new Order();
			
			o.setRentalId(rentalId);
//			o.setCustomerId(customerId);
			o.setCarId(carId);
			
			System.out.println("testing java");
			System.out.println(rentalId);
			
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		Order t = list.get(0);
//		int testId = t.getCarId();
//		System.out.println("test");
		return list;
	}

	@Override
	public String Update(String s) throws RemoteException {
		System.out.println("update");
		return null;
	}

	@Override
	public String Delete(String s) throws RemoteException {
		System.out.println("delete");
		return null;
	}

}
