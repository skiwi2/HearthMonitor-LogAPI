package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagChangeLogEntryTest {
    @Test
    public void testTagChange() {
        TagChangeLogEntry tagChangeLogEntry = new TagChangeLogEntry.Builder()
            .entity("entity")
            .tag("test")
            .value("random")
            .build();
        assertEquals("entity", tagChangeLogEntry.getEntity());
        assertEquals("test", tagChangeLogEntry.getTag());
        assertEquals("random", tagChangeLogEntry.getValue());
    }
}