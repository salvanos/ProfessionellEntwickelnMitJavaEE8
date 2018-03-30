package de.java2enterprise.onlineshop.jsonp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.jupiter.api.Test;

public class ReadJsonUTF8WithBOMTest {

    @Test
    public void testRead() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(
                    Paths.get("/tmp/gruss.json")));
            content = content.replaceFirst("\uFEFF", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (JsonReader jsonReader = Json
                .createReader(new StringReader(content))) {
            assertNotNull(jsonReader);
            JsonObject jsonObject = jsonReader.readObject();
            String gruss = jsonObject.getString("gruss");
            assertEquals("嗨世界", gruss);
        }
    }
}
