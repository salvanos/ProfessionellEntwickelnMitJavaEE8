package de.java2enterprise.onlineshop.jsonb;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerSerializeTest {
    private final static Logger LOGGER = Logger.getLogger(
            CustomerSerializeTest.class.getName());

    @Test
    public void testSerialize() {
        Customer customer = new Customer();
        customer.setId(123L);
        customer.setEmail("j@java2enterprise.de");
        customer.setPassword("Taxi_123");

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(customer);
        assertNotNull(json);
        LOGGER.info("Json-Dokument: " + json);
    }
}
