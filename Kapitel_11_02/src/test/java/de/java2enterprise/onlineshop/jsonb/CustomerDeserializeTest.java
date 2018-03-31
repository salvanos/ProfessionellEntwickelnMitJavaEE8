package de.java2enterprise.onlineshop.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerDeserializeTest {

    @Test
    public void testSetCustomerSimple() {
        String json = "{\"email\":\"j@java2enterprise.de\","
                + "\"id\":123,"
                + "\"password\":\"Taxi_123\"}";
        Jsonb jsonb = JsonbBuilder.create();
        Customer customer = jsonb.fromJson(json,
                Customer.class);
        System.out.println(customer);
    }

}
