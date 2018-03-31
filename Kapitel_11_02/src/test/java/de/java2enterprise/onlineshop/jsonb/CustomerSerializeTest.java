package de.java2enterprise.onlineshop.jsonb;

import static org.junit.Assert.assertNotNull;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerSerializeTest {

    @Test
    public void testSerialize() {
        Customer customer = new Customer();
        customer.setId(123L);
        customer.setEmail("j@java2enterprise.de");
        customer.setPassword("Taxi_123");

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(customer);
        assertNotNull(json);
        System.out.println(json);
    }
}
