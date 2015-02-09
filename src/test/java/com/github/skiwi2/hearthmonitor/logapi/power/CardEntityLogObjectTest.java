package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardEntityLogObjectTest {
    @Test
    public void testCardEntityCase1() {
        CardEntityLogObject cardEntityLogObject = new CardEntityLogObject.Builder()
            .name("Dread Infernal")
            .id("34")
            .zone("HAND")
            .zonePos("3")
            .cardId("CS2_064")
            .player("1")
            .build();
        assertEquals("Dread Infernal", cardEntityLogObject.getName());
        assertEquals("34", cardEntityLogObject.getId());
        assertEquals("HAND", cardEntityLogObject.getZone());
        assertEquals("3", cardEntityLogObject.getZonePos());
        assertEquals("CS2_064", cardEntityLogObject.getCardId());
        assertEquals("1", cardEntityLogObject.getPlayer());
    }

    @Test
    public void testCardEntityCase2() {
        CardEntityLogObject cardEntityLogObject = new CardEntityLogObject.Builder()
            .id("33")
            .cardId("")
            .type("INVALID")
            .zone("DECK")
            .zonePos("0")
            .player("1")
            .build();
        assertEquals("33", cardEntityLogObject.getId());
        assertEquals("", cardEntityLogObject.getCardId());
        assertEquals("INVALID", cardEntityLogObject.getType());
        assertEquals("DECK", cardEntityLogObject.getZone());
        assertEquals("0", cardEntityLogObject.getZonePos());
        assertEquals("1", cardEntityLogObject.getPlayer());
    }
}