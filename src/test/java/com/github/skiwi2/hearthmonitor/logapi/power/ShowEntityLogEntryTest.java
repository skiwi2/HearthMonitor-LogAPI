package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShowEntityLogEntryTest {
    @Test
    public void testShowEntity() {
        ShowEntityLogEntry showEntityLogEntry = new ShowEntityLogEntry.Builder()
            .indentation(4)
            .id("33")
            .cardId("")
            .type("INVALID")
            .zone("DECK")
            .zonePos("0")
            .player("1")
            .showCardId("CS2_062")
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();
        assertEquals(4, showEntityLogEntry.getIndentation());
        assertEquals("33", showEntityLogEntry.getId());
        assertEquals("", showEntityLogEntry.getCardId());
        assertEquals("INVALID", showEntityLogEntry.getType());
        assertEquals("DECK", showEntityLogEntry.getZone());
        assertEquals("0", showEntityLogEntry.getZonePos());
        assertEquals("1", showEntityLogEntry.getPlayer());
        assertEquals("CS2_062", showEntityLogEntry.getShowCardId());
        assertEquals("random", showEntityLogEntry.getTagValue("test"));
        assertEquals("random2", showEntityLogEntry.getTagValue("test2"));
    }
}