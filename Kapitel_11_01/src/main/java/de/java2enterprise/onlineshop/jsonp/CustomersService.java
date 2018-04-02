package de.java2enterprise.onlineshop.jsonp;

import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonPointer;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;

public class CustomersService {
    private final static Logger LOGGER = Logger.getLogger(
            CustomersService.class.getName());

    public JsonStructure replaceValue(
            JsonStructure jsonStructure,
            String point,
            String newValue) {

        JsonPointer jsonPointer = Json.createPointer(point);
        JsonValue jsonValue = jsonPointer
                .getValue(jsonStructure);
        LOGGER.info("JsonValue: " + jsonValue);

        JsonString newJsonString = Json
                .createValue(newValue);
        return jsonPointer.replace(jsonStructure,
                newJsonString);
    }
}
