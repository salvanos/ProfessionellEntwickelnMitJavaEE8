package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertNotNull;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

public class CustomerServiceSimpleTest {

    @Test
    public void testGetCustomerSimple() {
        CustomerService customerService = new CustomerService();
        JsonObject jsonObject = customerService
                .getCustomer(1L, "Peter Schmidt", "Goebenstr.5");
        assertNotNull(jsonObject);
        System.out.println(jsonObject);
    }
}
