package ie.gmit.sw.Rest;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	// Create
	@POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("insert")
    public void insert(Order o) throws Exception {
		RMI r = new RMI();
    	r.setData(o);
    }
	
	// Read
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("read/{value}")
    public Order getIt(@PathParam("value") int n) throws Exception {
    	RMI r = new RMI();
    	return r.getData(n);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("read")
    public List<Order> orserread() throws Exception{
    	RMI r = new RMI();
    	return r.getData();
    }
    
    // Update
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("update")
    public void update(Order o) throws Exception {
    	RMI r = new RMI();
    	r.update(o);
    }
    
    // Delete
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    @Path("delete")
    public void delete(Order o) throws Exception {
    	RMI r = new RMI();
    	r.delete(o);
    }
}
