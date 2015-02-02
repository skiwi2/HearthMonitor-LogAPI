package com.github.skiwi2.hearthmonitor.logapi.zone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitioningLogEntryTest {
    @Test
    public void testTransitioning() {
        TransitioningLogEntry transitioningLogEntry = new TransitioningLogEntry.Builder()
            .indentation(2)
            .name("test")
            .id("1")
            .zone("zone1")
            .zonePos("2")
            .cardId("3")
            .player("4")
            .targetZone("zone2")
            .build();
        assertEquals(2, transitioningLogEntry.getIndentation());
        assertEquals("test", transitioningLogEntry.getName());
        assertEquals("1", transitioningLogEntry.getId());
        assertEquals("zone1", transitioningLogEntry.getZone());
        assertEquals("2", transitioningLogEntry.getZonePos());
        assertEquals("3", transitioningLogEntry.getCardId());
        assertEquals("4", transitioningLogEntry.getPlayer());
        assertEquals("zone2", transitioningLogEntry.getTargetZone());
    }
}