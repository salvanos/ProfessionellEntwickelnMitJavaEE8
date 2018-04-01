package de.marktware.othershop_web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent to the
     * client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("id") Long id) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(
                "http://localhost:8080/onlineshop-web/resources/customer")
                .path("{id}").resolveTemplate("id", id);

        String jsonString = webTarget
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        client.close();
        return jsonString;
    }
}
