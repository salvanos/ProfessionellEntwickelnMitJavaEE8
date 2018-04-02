package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

public class CustomerServiceSimpleTest {
    private final static Logger LOGGER = Logger.getLogger(
            CustomerServiceSimpleTest.class.getName());

    @Test
    public void testGetCustomerSimple() {
        CustomerService customerService = new CustomerService();
        JsonObject jsonObject = customerService.getCustomer(
                1L,
                "Peter Schmidt",
                "Goebenstr.5");
        assertNotNull(jsonObject);
        LOGGER.info("jsonObject: " + jsonObject);
    }
}
