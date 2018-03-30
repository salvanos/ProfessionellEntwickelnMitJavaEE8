package de.java2enterprise.onlineshop.jsonp;

import javax.json.Json;
import javax.json.JsonPointer;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;

public class CustomersService {
    public JsonStructure replaceValue(
            JsonStructure jsonStructure,
            String point,
            String newValue) {

        JsonPointer jsonPointer = Json.createPointer(point);
        JsonValue jsonValue = jsonPointer
                .getValue(jsonStructure);
        System.out.println(jsonValue);

        JsonString newJsonString = Json
                .createValue(newValue);
        return jsonPointer.replace(jsonStructure,
                newJsonString);
    }
}
