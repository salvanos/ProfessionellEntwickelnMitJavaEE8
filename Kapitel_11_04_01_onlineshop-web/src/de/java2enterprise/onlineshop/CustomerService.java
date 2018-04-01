package de.java2enterprise.onlineshop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.java2enterprise.onlineshop.model.Customer;

@Path("customer")
public class CustomerService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String find() {
        Customer customer = new Customer();
        customer.setEmail("j@java2enterprise.de");
        customer.setPassword("Taxi_123");
        return customer.toString();
    }
}
