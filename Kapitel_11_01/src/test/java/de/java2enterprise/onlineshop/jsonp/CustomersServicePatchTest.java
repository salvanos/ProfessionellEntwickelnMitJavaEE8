package de.java2enterprise.onlineshop.jsonp;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonPatch;
import javax.json.JsonReader;

import org.junit.jupiter.api.Test;

public class CustomersServicePatchTest {

    @Test
    public void testReplaceValueWithPatch()
            throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(
                new FileReader("/tmp/customers.json"));
        JsonArray jsonArray = jsonReader.readArray();

        JsonPatch jsonPatch = Json.createPatchBuilder()
                .replace("/0/strasse", "Weberstr.22")
                .build();

        JsonArray newJsonArray = jsonPatch.apply(jsonArray);
        System.out.println(newJsonArray);
    }

}
