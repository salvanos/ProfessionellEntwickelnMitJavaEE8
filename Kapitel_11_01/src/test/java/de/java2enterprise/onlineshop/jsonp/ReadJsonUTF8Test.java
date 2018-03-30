package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.jupiter.api.Test;

public class ReadJsonUTF8Test {

    @Test
    public void testRead() {
        try (JsonReader jsonReader = Json.createReader(
                new FileReader("/tmp/gruss.json"))) {
            assertNotNull(jsonReader);
            JsonObject jsonObject = jsonReader.readObject();
            String gruss = jsonObject.getString("gruss");
            assertEquals("嗨世界", gruss);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
