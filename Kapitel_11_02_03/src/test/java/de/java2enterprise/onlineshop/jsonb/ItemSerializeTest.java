package de.java2enterprise.onlineshop.jsonb;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Item;

public class ItemSerializeTest {
    private final static Logger LOGGER = Logger
            .getLogger(ItemSerializeTest.class.getName());

    @Test
    public void testSerialize() {
        Item item = new Item();
        item.setId(1L);
        item.setTitle("Kirschlorbeer");
        item.setDescription("Arten von Prunus");
        item.setPrice(123.45);
        item.setSold(LocalDateTime.now());

        JsonbConfig jsonbConfig = new JsonbConfig();
        jsonbConfig.withDateFormat("dd.MM.yyyy", Locale.GERMAN);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        String json = jsonb.toJson(item);
        assertNotNull(json);
        LOGGER.info("Json-Dokument: " + json);
    }
}
