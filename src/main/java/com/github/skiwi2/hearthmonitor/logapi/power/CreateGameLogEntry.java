package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.HashSet;
import java.util.Set;

/**
 * Entry for [Power] CREATE_GAME.
 *
 * @author Frank van Heeswijk
 */
public class CreateGameLogEntry implements LogEntry {
    /*
     * [Power] GameState.DebugPrintPower() - CREATE_GAME
     * [Power] GameState.DebugPrintPower() -     GameEntity EntityID=1
     * [Power] GameState.DebugPrintPower() -         tag=10 value=85
     * [Power] GameState.DebugPrintPower() -         tag=TURN value=1
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=PLAY
     * [Power] GameState.DebugPrintPower() -         tag=ENTITY_ID value=1
     * [Power] GameState.DebugPrintPower() -         tag=NEXT_STEP value=BEGIN_MULLIGAN
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=GAME
     * [Power] GameState.DebugPrintPower() -         tag=STATE value=RUNNING
     * [Power] GameState.DebugPrintPower() -     Player EntityID=2 PlayerID=1 GameAccountId=[hi=144115198130930503 lo=27162067]
     * [Power] GameState.DebugPrintPower() -         tag=TIMEOUT value=75
     * [Power] GameState.DebugPrintPower() -         tag=PLAYSTATE value=PLAYING
     * [Power] GameState.DebugPrintPower() -         tag=CURRENT_PLAYER value=1
     * [Power] GameState.DebugPrintPower() -         tag=FIRST_PLAYER value=1
     * [Power] GameState.DebugPrintPower() -         tag=HERO_ENTITY value=4
     * [Power] GameState.DebugPrintPower() -         tag=MAXHANDSIZE value=10
     * [Power] GameState.DebugPrintPower() -         tag=STARTHANDSIZE value=4
     * [Power] GameState.DebugPrintPower() -         tag=PLAYER_ID value=1
     * [Power] GameState.DebugPrintPower() -         tag=TEAM_ID value=1
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=PLAY
     * [Power] GameState.DebugPrintPower() -         tag=CONTROLLER value=1
     * [Power] GameState.DebugPrintPower() -         tag=ENTITY_ID value=2
     * [Power] GameState.DebugPrintPower() -         tag=MAXRESOURCES value=10
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=PLAYER
     * [Power] GameState.DebugPrintPower() -         tag=NUM_TURNS_LEFT value=1
     * [Power] GameState.DebugPrintPower() -     Player EntityID=3 PlayerID=2 GameAccountId=[hi=144115198130930503 lo=37543301]
     * [Power] GameState.DebugPrintPower() -         tag=TIMEOUT value=75
     * [Power] GameState.DebugPrintPower() -         tag=PLAYSTATE value=PLAYING
     * [Power] GameState.DebugPrintPower() -         tag=HERO_ENTITY value=36
     * [Power] GameState.DebugPrintPower() -         tag=MAXHANDSIZE value=10
     * [Power] GameState.DebugPrintPower() -         tag=STARTHANDSIZE value=4
     * [Power] GameState.DebugPrintPower() -         tag=PLAYER_ID value=2
     * [Power] GameState.DebugPrintPower() -         tag=TEAM_ID value=2
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=PLAY
     * [Power] GameState.DebugPrintPower() -         tag=CONTROLLER value=2
     * [Power] GameState.DebugPrintPower() -         tag=ENTITY_ID value=3
     * [Power] GameState.DebugPrintPower() -         tag=MAXRESOURCES value=10
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=PLAYER
     * [Power] GameState.DebugPrintPower() -         tag=NUM_TURNS_LEFT value=1
     */

    private final int indentation;
    private final GameEntityLogEntry gameEntityLogEntry;
    private final Set<PlayerLogEntry> playerLogEntries;

    private CreateGameLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.gameEntityLogEntry = Objects.requireNonNull(builder.gameEntityLogEntry, "builder.gameEntityLogEntry");
        this.playerLogEntries = Objects.requireNonNull(builder.playerLogEntries, "builder.playerLogEntries");
    }

    public int getIndentation() {
        return indentation;
    }

    public GameEntityLogEntry getGameEntityLogEntry() {
        return gameEntityLogEntry;
    }

    public Set<PlayerLogEntry> getPlayerLogEntries() {
        return new HashSet<PlayerLogEntry>(playerLogEntries);
    }

    public static class Builder {
        private int indentation;
        private GameEntityLogEntry gameEntityLogEntry;
        private Set<PlayerLogEntry> playerLogEntries = new HashSet<PlayerLogEntry>();

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder gameEntityLogEntry(final GameEntityLogEntry gameEntityLogEntry) {
            this.gameEntityLogEntry = Objects.requireNonNull(gameEntityLogEntry, "gameEntityLogEntry");
            return this;
        }

        public Builder addPlayerLogEntry(final PlayerLogEntry playerLogEntry) {
            Objects.requireNonNull(playerLogEntry, "playerLogEntry");
            this.playerLogEntries.add(playerLogEntry);
            return this;
        }

        public CreateGameLogEntry build() {
            return new CreateGameLogEntry(this);
        }
    }
}
