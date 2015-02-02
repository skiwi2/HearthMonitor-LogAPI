package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.power.CreateGameLogEntry.GameEntityLogEntry;
import com.github.skiwi2.hearthmonitor.logapi.power.CreateGameLogEntry.PlayerLogEntry;
import com.github.skiwi2.hearthmonitor.logapi.power.CreateGameLogEntry.PlayerLogEntry.GameAccountId;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class CreateGameLogEntryTest {
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

    @Test
    public void testCreateGameLogEntry() {
        GameEntityLogEntry gameEntityLogEntry = new GameEntityLogEntry.Builder()
            .indentation(4)
            .entityId("1")
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();

        GameAccountId gameAccountId1 = new GameAccountId.Builder()
            .hi("2")
            .lo("1")
            .build();

        PlayerLogEntry playerLogEntry1 = new PlayerLogEntry.Builder()
            .indentation(4)
            .playerId("1")
            .entityId("2")
            .gameAccountId(gameAccountId1)
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();

        GameAccountId gameAccountId2 = new GameAccountId.Builder()
            .hi("4")
            .lo("3")
            .build();

        PlayerLogEntry playerLogEntry2 = new PlayerLogEntry.Builder()
            .indentation(4)
            .playerId("2")
            .entityId("3")
            .gameAccountId(gameAccountId2)
            .addTagValuePair("test", "random")
            .addTagValuePair("test2", "random2")
            .build();

        CreateGameLogEntry createGameLogEntry = new CreateGameLogEntry.Builder()
            .indentation(2)
            .gameEntityLogEntry(gameEntityLogEntry)
            .addPlayerLogEntry(playerLogEntry1)
            .addPlayerLogEntry(playerLogEntry2)
            .build();
        assertEquals(2, createGameLogEntry.getIndentation());
        assertEquals(gameEntityLogEntry, createGameLogEntry.getGameEntityLogEntry());
        assertThat(createGameLogEntry.getPlayerLogEntries(), hasItems(playerLogEntry1, playerLogEntry2));
    }
 }