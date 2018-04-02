package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import org.junit.jupiter.api.Test;

public class CustomerServiceWriteReadTest {
    final String customerFilePath = "/tmp/customer.json";

    @Test
    public void getCustomer() {
        CustomerService customerService = new CustomerService();
        JsonObject jsonObject = customerService
                .getCustomer(1L, "Peter Schmidt", "Goebenstr.5");
        assertNotNull(jsonObject);

        writeCustomerToDisk(jsonObject);
        jsonObject = readCustomerFromDisk();

        assertNotNull(jsonObject);

        long id = jsonObject.getJsonNumber("id").longValue();
        assertEquals(1, id);

        String name = jsonObject.getJsonString("name").getString();
        assertEquals("Peter Schmidt", name);

        String strasse = jsonObject.getString("strasse");
        assertEquals("Goebenstr.5", strasse);
    }

    private void writeCustomerToDisk(
            JsonObject jsonObject) {
        try (JsonWriter jsonWriter = Json.createWriter(
                new FileWriter(customerFilePath))) {
            jsonWriter.write(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonObject readCustomerFromDisk() {
        JsonObject jsonObject = null;
        try (JsonReader jsonReader = Json.createReader(
                new FileReader(customerFilePath))) {
            jsonObject = jsonReader.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
