package ie.gmit.sw.Rest;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.CarHireRest.CarHireService;
import ie.gmit.sw.CarHireRest.RMI;
import ie.gmit.sw.model.Order;

@Singleton
@Path("/myresource")
public class MyResource {

    
	public MyResource() {
		System.out.println("Hello again..");
	}
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{value}")
    public Response getIt(@PathParam("value") String s) throws Exception {
    	
    	RMI r = new RMI();
    	String output = " my name is " + s;
    	System.out.println(output);
    	
    	List<Order> list = r.getData();
    	
//    	Order t = list.get(0);
//		int testId = t.getCarId();
//		System.out.println("test");
//		return list;
    	
//    	System.out.print(r.getData());
    	
        return Response.status(201).entity("works").build();
    }
}
