package de.java2enterprise.onlineshop.jsonb;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

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

        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withFormatting(true)
                .withPropertyNamingStrategy(
                        PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        String json = jsonb.toJson(customer);
        assertNotNull(json);
        LOGGER.info("Json-Dokument: " + json);
    }
}
