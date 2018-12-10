package ie.gmit.sw.CarHireRest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.model.Order;

public interface CarHireService extends Remote{

	// create hire
	public void Create(Order o) throws RemoteException, SQLException;
	
	// read all hire
	public List<Order> Read() throws RemoteException, Exception; 
	
	// update hire
	public void Update(Order o) throws Exception;
	
	// delete hire 
	public void Delete(Order o) throws RemoteException, SQLException;

}
