package de.java2enterprise.onlineshop.jsonp;

import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.junit.jupiter.api.Test;

public class ReadJsonFromGoogle {
    String address = "bonn+goebenstr.5";
    String googleapi = "http://maps.googleapis.com/maps/api/geocode/json?address=";
    
    @Test
    public void test() {
        URL url;
        InputStream in = null;
        try {
            url = new URL(googleapi + address);
            in = url.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (JsonReader jsonReader = 
                Json.createReader(in)) {
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray results = jsonObject.getJsonArray("results");
            for (JsonValue result : results) {
                if(result.getValueType() == JsonValue.ValueType.OBJECT) {
                    JsonObject rJsonObject = (JsonObject)result;
                    JsonObject geometry = rJsonObject.getJsonObject("geometry");
                    JsonObject location = geometry.getJsonObject("location");
                    JsonNumber lat = location.getJsonNumber("lat");
                    System.out.println("Breitengrad: " + lat.doubleValue());
                    JsonNumber lng = location.getJsonNumber("lng");
                    System.out.println("Längengrad: " + lng.doubleValue());
                }
            }
        }
    }
}
