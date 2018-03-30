package de.java2enterprise.onlineshop.jsonp;

import javax.json.Json;
import javax.json.JsonObject;

public class CustomerService {

    public JsonObject getCustomer(long id, String name, String strasse) {
        return Json.createObjectBuilder()
            .add("id", id).add("name", name).add("strasse", strasse).build();
    }
}

