package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.power.PlayerLogEntry.GameAccountId;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class CreateGameLogEntryTest {
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