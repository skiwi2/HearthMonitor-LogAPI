package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagChangeLogEntryTest {
    @Test
    public void testTagChange() {
        EntityLogObject playerEntity = new PlayerEntityLogObject.Builder()
            .name("yourname")
            .build();

        TagChangeLogEntry tagChangeLogEntry = new TagChangeLogEntry.Builder()
            .indentation(4)
            .entity(playerEntity)
            .tag("test")
            .value("random")
            .build();
        assertEquals(4, tagChangeLogEntry.getIndentation());
        assertEquals(playerEntity, tagChangeLogEntry.getEntity());
        assertEquals("test", tagChangeLogEntry.getTag());
        assertEquals("random", tagChangeLogEntry.getValue());
    }
}