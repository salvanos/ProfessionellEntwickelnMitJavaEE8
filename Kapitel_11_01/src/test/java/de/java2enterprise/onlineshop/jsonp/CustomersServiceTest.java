package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import org.junit.jupiter.api.Test;

public class CustomersServiceTest {
    @Test
    public void testReplaceValue()
            throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(
                new FileReader("/tmp/customers.json"));
        JsonStructure jsonStructure = jsonReader.read();

        CustomersService customersService = new CustomersService();
        JsonStructure newJsonStructure = customersService
                .replaceValue(jsonStructure,
                        "/0/strasse",
                        "Weberstr.22");
        assertNotNull(newJsonStructure);
        System.out.println(newJsonStructure);
    }
}
