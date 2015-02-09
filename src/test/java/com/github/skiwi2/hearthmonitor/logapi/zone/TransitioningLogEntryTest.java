package com.github.skiwi2.hearthmonitor.logapi.zone;

import com.github.skiwi2.hearthmonitor.logapi.power.CardEntityLogObject;
import com.github.skiwi2.hearthmonitor.logapi.power.EntityLogObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitioningLogEntryTest {
    @Test
    public void testTransitioning() {
        EntityLogObject cardEntity = new CardEntityLogObject.Builder()
            .name("test")
            .id("1")
            .zone("zone1")
            .zonePos("2")
            .cardId("3")
            .player("4")
            .build();

        TransitioningLogEntry transitioningLogEntry = new TransitioningLogEntry.Builder()
            .indentation(2)
            .entity(cardEntity)
            .targetZone("zone2")
            .build();
        assertEquals(2, transitioningLogEntry.getIndentation());
        assertEquals(cardEntity, transitioningLogEntry.getEntity());
        assertEquals("zone2", transitioningLogEntry.getTargetZone());
    }
}