package de.java2enterprise.onlineshop.jsonp;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import org.junit.jupiter.api.Test;

public class WriteJsonUTF8Test {

    @Test
    public void testWrite() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("gruss", "嗨世界").build();

        try (JsonWriter jsonWriter = Json.createWriter(
                new FileWriter("/tmp/gruss.json"))) {
            jsonWriter.write(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
