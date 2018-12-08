package ie.gmit.sw.CarHireRest;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {
	
	public static void main(String[] args) throws Exception {
		
		CarHireService ds = new CarServiceImpl();
		
		// Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
	
		// Bind our remote object to the registry with the human-readable name
		Naming.rebind("databaseService", ds);

		System.out.println("started");
	}

}
