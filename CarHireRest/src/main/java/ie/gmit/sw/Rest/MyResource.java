package ie.gmit.sw.Rest;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.CarHireRest.RMI;
import ie.gmit.sw.model.Order;

@Singleton
@Path("myresource")
public class MyResource {

    
	public MyResource() {
		System.out.println("Hello again..");
	}
	
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/read/{value}")
    public Order getIt(@PathParam("value") int n) throws Exception {
    	
    	RMI r = new RMI();
    	
//    	List<Order> list = r.getData();
//    	
//    	Order order = list.get(n);
//    	
//    	Order t = list.get(0);
//		int testId = t.getCarId();
    	
//    	System.out.print(r.getData());
    	
//        return Response.status(201).entity("works").build();
//    	return order.getRentalId();
    	return r.getData(n);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("read")
    public List<Order> orserread() throws Exception{
    	
    	RMI r = new RMI();
    	
    	return r.getData();
    	
    }
    
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/update/{customerIdUpt}")
    public int update(@PathParam("customerIdUpt") int customerIdUpt) throws Exception {
    	
    	RMI r = new RMI();
    	int carIdUpt = 999;
    	r.update(1, carIdUpt);
//    	Order t = list.get(0);
//		int testId = t.getCarId();
    	
//    	System.out.print(r.getData());
    	
//        return Response.status(201).entity("works").build();
    	return customerIdUpt;
    }
}
