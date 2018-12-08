package ie.gmit.sw.CarHireRest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.model.Order;

public interface CarHireService extends Remote{

	// create hire
	public String Create(String s) throws RemoteException;
	
	// read all hire
	public List<Order> Read() throws RemoteException, Exception; 
	
	// update hire
	public String Update(int customerIdUpt, int carIdUpt) throws RemoteException, SQLException;
	
	// delete hire 
	public String Delete(String s) throws RemoteException;

}
