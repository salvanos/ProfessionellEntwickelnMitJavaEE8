package de.java2enterprise.onlineshop.jsonb;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomersSerializeTest {
    private final static Logger LOGGER = Logger.getLogger(
            CustomersSerializeTest.class.getName());

    @Test
    public void testSerialize() {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(123L);
        customer1.setEmail("j@java2enterprise.de");
        customer1.setPassword("Taxi_123");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(456L);
        customer2.setEmail("k@java2enterprise.de");
        customer2.setPassword("Taxi_456");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(789L);
        customer3.setEmail("l@java2enterprise.de");
        customer3.setPassword("Taxi_789");
        customers.add(customer3);

        Customer customer4 = new Customer();
        customer4.setId(111L);
        customer4.setEmail("a@java2enterprise.de");
        customers.add(customer4);        

        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withFormatting(true);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        String json = jsonb.toJson(customers);
        assertNotNull(json);
        LOGGER.info("Json-Dokument: " + json);

        jsonb.fromJson(json, ArrayList.class).stream()
                .forEach(System.out::println);

        customers = jsonb.fromJson(json,
                new ArrayList<Customer>() {
                }.getClass().getGenericSuperclass());
        LOGGER.info("Customers: " + customers);

    }
}
