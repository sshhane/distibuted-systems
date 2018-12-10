package ie.gmit.sw.CarHireRest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
	public void Create(Order o) throws RemoteException, SQLException {
		System.out.println("sql");
		statement = connection.createStatement();
		
		int rentalId = o.getRentalId();
		int carId = o.getCarId();
		int customerId = o.getCustomerId();
//		Date date = o.getDate();
		
		String sqlInsert = "insert into Rentals values(" + rentalId + ", " + carId + ", " + customerId + ", curdate());";
		
		System.out.println(sqlInsert);
		
		statement.execute(sqlInsert);
//		int countInserted = statement.executeUpdate(sqlInsert);
//		ResultSet reset = statement.executeQuery(sqlInsert);
		
//		countInserted = statement.executeUpdate(sqlInsert);

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
			int customerId = reset.getInt("customerId");
			int carId = reset.getInt("carId");
			Date date = reset.getDate("Date");
			
			Order o = new Order(rentalId, carId, customerId, date);
			
			list.add(o);
			
		}
		
		return list;
	}

	@Override
	public void Update(Order o) throws Exception {
		System.out.println("update");
		
		int rentalId = o.getRentalId();
		int carId = o.getCarId();
		
		statement = connection.createStatement();
		
        String update = "UPDATE Rentals SET carId = " + carId + " WHERE rentalId = " + rentalId + ";";
        
        int countUpdated = statement.executeUpdate(update);

        ResultSet rset = statement.executeQuery(update);
        
	}

	@Override
	public void Delete(Order o) throws RemoteException, SQLException {
		System.out.println("delete");
		
		int rentalId = o.getRentalId();
		
		statement = connection.createStatement();
		
		 String sqlDelete = "DELETE FROM Rentals where rentalId = " + rentalId + ";";
		 
		 System.out.println(sqlDelete);
		 
		 statement.executeUpdate(sqlDelete);
	}

}
