package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShowEntityLogEntryTest {
    @Test
    public void testShowEntity() {
        EntityLogObject cardEntity = new CardEntityLogObject.Builder()
            .id("33")
            .cardId("")
            .type("INVALID")
            .zone("DECK")
            .zonePos("0")
            .player("1")
            .build();

        ShowEntityLogEntry showEntityLogEntry = new ShowEntityLogEntry.Builder()
            .indentation(4)
            .entity(cardEntity)
            .cardId("CS2_062")
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();
        assertEquals(4, showEntityLogEntry.getIndentation());
        assertEquals(cardEntity, showEntityLogEntry.getEntity());
        assertEquals("CS2_062", showEntityLogEntry.getCardId());
        assertEquals("random", showEntityLogEntry.getTagValue("test"));
        assertEquals("random2", showEntityLogEntry.getTagValue("test2"));
    }
}