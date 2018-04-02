package de.java2enterprise.onlineshop.jsonp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import org.junit.jupiter.api.Test;

public class ReadJsonGenericallyTest {
    private final static Logger LOGGER = Logger.getLogger(
            ReadJsonGenericallyTest.class.getName());
    private String json = "";

    @Test
    public void test() {
        try (JsonReader jsonReader = Json
                .createReader(new FileReader(
                        new File("/tmp/customer.json")))) {
            JsonStructure jsonStructure = jsonReader.read();
            navigate(null, jsonStructure);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("json: " + json);
    }

    private void navigate(String key, JsonValue value) {
        if (key != null) {
            json += ("\"" + key + "\"" + ":");
        }
        switch (value.getValueType()) {
        case OBJECT:
            JsonObject object = (JsonObject) value;
            json += "{";
            boolean firstObjectElement = true;
            for (Entry<String, JsonValue> entry : object
                    .entrySet()) {
                if (!firstObjectElement) {
                    json += ",";
                }
                firstObjectElement = false;
                navigate(entry.getKey(), entry.getValue());
            }
            json += "}";
            break;
        case ARRAY:
            JsonArray jsonArray = (JsonArray) value;
            json += "[";
            boolean firstArrayElement = true;
            for (JsonValue jsonValue : jsonArray) {
                if (!firstArrayElement) {
                    json += ",";
                }
                firstArrayElement = false;
                navigate(null, jsonValue);
            }
            json += "]";
            break;
        case STRING:
            json += value;
            break;
        default:
            json += value;
            break;
        }
    }
}
