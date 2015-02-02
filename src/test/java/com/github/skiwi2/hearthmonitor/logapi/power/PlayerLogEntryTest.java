package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.power.PlayerLogEntry.GameAccountId;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerLogEntryTest {
    @Test
    public void testGameAccountId() {
        GameAccountId gameAccountId = new GameAccountId.Builder()
            .hi("2")
            .lo("1")
            .build();
        assertEquals("2", gameAccountId.getHi());
        assertEquals("1", gameAccountId.getLo());
    }

    @Test
    public void testPlayerLogEntry() {
        GameAccountId gameAccountId = new GameAccountId.Builder()
            .hi("2")
            .lo("1")
            .build();

        PlayerLogEntry playerLogEntry = new PlayerLogEntry.Builder()
            .indentation(4)
            .playerId("1")
            .entityId("2")
            .gameAccountId(gameAccountId)
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();
        assertEquals(4, playerLogEntry.getIndentation());
        assertEquals("1", playerLogEntry.getPlayerId());
        assertEquals("2", playerLogEntry.getEntityId());
        assertEquals(gameAccountId, playerLogEntry.getGameAccountId());
        assertEquals("random", playerLogEntry.getTagValue("test"));
        assertEquals("random2", playerLogEntry.getTagValue("test2"));
    }
}