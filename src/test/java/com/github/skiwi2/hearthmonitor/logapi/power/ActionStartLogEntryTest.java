package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class ActionStartLogEntryTest {
    @Test
    public void testActionStartTrigger() {
        LogEntry logEntry1 = new TestLogEntry();
        LogEntry logEntry2 = new TestLogEntry();

        EntityLogObject playerEntity = new PlayerEntityLogObject.Builder()
            .name("skiwi")
            .build();

        ActionStartLogEntry actionStartLogEntry = new ActionStartLogEntry.Builder()
            .indentation(0)
            .entity(playerEntity)
            .subtype("TRIGGER")
            .index("-1")
            .target("0")
            .addLogEntry(logEntry1)
            .addLogEntry(logEntry2)
            .build();
        assertEquals(0, actionStartLogEntry.getIndentation());
        assertEquals(playerEntity, actionStartLogEntry.getEntity());
        assertEquals("TRIGGER", actionStartLogEntry.getSubtype());
        assertEquals("-1", actionStartLogEntry.getIndex());
        assertEquals("0", actionStartLogEntry.getTarget());
        assertThat(actionStartLogEntry.getLogEntries(), hasItems(logEntry1, logEntry2));
    }

    private static class TestLogEntry implements LogEntry { }
}