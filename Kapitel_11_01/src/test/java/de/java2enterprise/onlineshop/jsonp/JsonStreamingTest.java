package de.java2enterprise.onlineshop.jsonp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

import org.junit.jupiter.api.Test;

public class JsonStreamingTest {

    @Test
    public void test() {
        File file = new File("/tmp/customer.json");
        try (JsonGenerator jsonGenerator = 
                Json.createGenerator(new FileWriter(file))) {
            jsonGenerator.writeStartObject();
            jsonGenerator.write("id", 1);
            jsonGenerator.write("name", "Peter Schmidt");
            jsonGenerator.write("strasse", "Goebenstr.5");
            jsonGenerator.writeEnd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
