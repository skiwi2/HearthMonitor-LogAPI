package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameEntityLogEntryTest {
    @Test
    public void testGameEntityLogEntry() {
        GameEntityLogEntry gameEntityLogEntry = new GameEntityLogEntry.Builder()
            .indentation(4)
            .entityId("1")
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();
        assertEquals(4, gameEntityLogEntry.getIndentation());
        assertEquals("1", gameEntityLogEntry.getEntityId());
        assertEquals("random", gameEntityLogEntry.getTagValue("test"));
        assertEquals("random2", gameEntityLogEntry.getTagValue("test2"));
    }
}