package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class FullEntityLogEntryTest {
    @Test
    public void testFullEntity() {
        FullEntityLogEntry fullEntityLogEntry = new FullEntityLogEntry.Builder()
            .id("1")
            .cardId("2")
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();
        assertEquals("1", fullEntityLogEntry.getId());
        assertEquals("2", fullEntityLogEntry.getCardId());
        assertEquals("random", fullEntityLogEntry.getTagValue("test"));
        assertEquals("random2", fullEntityLogEntry.getTagValue("test2"));
    }
}