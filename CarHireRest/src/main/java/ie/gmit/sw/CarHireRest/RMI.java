package ie.gmit.sw.CarHireRest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.model.Order;

public class RMI  {

	private CarHireService chs;
	
	public RMI() throws MalformedURLException, RemoteException, NotBoundException {
		chs = (CarHireService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");
		System.out.println("Connected..");
	}
	
	public List<Order> getData() throws Exception{
		
		return chs.Read();
	}

}

