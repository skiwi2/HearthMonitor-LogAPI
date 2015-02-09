package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class HideEntityLogEntryTest {
    @Test
    public void testHideEntity() {
        EntityLogObject cardEntity = new CardEntityLogObject.Builder()
            .name("Dread Infernal")
            .id("34")
            .zone("HAND")
            .zonePos("3")
            .cardId("CS2_064")
            .player("1")
            .build();

        HideEntityLogEntry hideEntityLogEntry = new HideEntityLogEntry.Builder()
            .indentation(4)
            .entity(cardEntity)
            .tag("ZONE")
            .value("DECK")
            .build();
        assertEquals(4, hideEntityLogEntry.getIndentation());
        assertEquals(cardEntity, hideEntityLogEntry.getEntity());
        assertEquals("ZONE", hideEntityLogEntry.getTag());
        assertEquals("DECK", hideEntityLogEntry.getValue());
    }
}