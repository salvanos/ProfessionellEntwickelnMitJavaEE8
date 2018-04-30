package de.java2enterprise.onlineshop.jsonb;

import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerDeserializeTest {
    private final static Logger LOGGER = Logger.getLogger(
            CustomerDeserializeTest.class.getName());


    @Test
    public void testSetCustomerSimple() {
        String json = "{\"user\":\"j@java2enterprise.de\","
                + "\"id\":123,"
                + "\"password\":\"Taxi_123\"}";
        Jsonb jsonb = JsonbBuilder.create();
        Customer customer = jsonb.fromJson(json,
                Customer.class);
        LOGGER.info("Customer: " + customer);
    }

}
