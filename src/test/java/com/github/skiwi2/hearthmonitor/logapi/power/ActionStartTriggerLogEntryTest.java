package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class ActionStartTriggerLogEntryTest {
    @Test
    public void testActionStartTrigger() {
        LogEntry logEntry1 = new TestLogEntry();
        LogEntry logEntry2 = new TestLogEntry();

        ActionStartTriggerLogEntry actionStartTriggerLogEntry = new ActionStartTriggerLogEntry.Builder()
            .indentation(0)
            .entity("skiwi")
            .subtype("TRIGGER")
            .index("-1")
            .target("0")
            .addLogEntry(logEntry1)
            .addLogEntry(logEntry2)
            .build();
        assertEquals(0, actionStartTriggerLogEntry.getIndentation());
        assertEquals("skiwi", actionStartTriggerLogEntry.getEntity());
        assertEquals("TRIGGER", actionStartTriggerLogEntry.getSubtype());
        assertEquals("-1", actionStartTriggerLogEntry.getIndex());
        assertEquals("0", actionStartTriggerLogEntry.getTarget());
        assertThat(actionStartTriggerLogEntry.getLogEntries(), hasItems(logEntry1, logEntry2));
    }

    private static class TestLogEntry implements LogEntry { }
}