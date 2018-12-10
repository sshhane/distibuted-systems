package ie.gmit.sw.CarHireRest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.model.Order;

public class RMI  {

	private CarHireService chs;
	
	public RMI() throws MalformedURLException, RemoteException, NotBoundException {
		chs = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService"); // port where database is 
		System.out.println("Connected..");
	}
	
	// read
	public Order getData(int n) throws Exception{
		List<Order> list = chs.Read();
    	Order o = list.get(n);
		return o;
	}
	
	public List<Order> getData() throws Exception{
		return chs.Read();
	}
	
	// update
	public void update(Order o) throws Exception {
		chs.Update(o);
	}

	// create
	public void setData(Order o) throws RemoteException, SQLException {
		chs.Create(o);
	}
	
	// Delete
	public void delete(Order o) throws RemoteException, SQLException {
		chs.Delete(o);
	}
}

