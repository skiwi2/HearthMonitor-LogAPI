package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;
import com.github.skiwi2.hearthmonitor.logapi.LogObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * Entry for [Power] CREATE_GAME - GameEntity.
     */
    public static class GameEntityLogEntry implements LogEntry {
        /*
         * [Power] GameState.DebugPrintPower() -     GameEntity EntityID=1
         * [Power] GameState.DebugPrintPower() -         tag=10 value=85
         * [Power] GameState.DebugPrintPower() -         tag=TURN value=1
         * [Power] GameState.DebugPrintPower() -         tag=ZONE value=PLAY
         * [Power] GameState.DebugPrintPower() -         tag=ENTITY_ID value=1
         * [Power] GameState.DebugPrintPower() -         tag=NEXT_STEP value=BEGIN_MULLIGAN
         * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=GAME
         * [Power] GameState.DebugPrintPower() -         tag=STATE value=RUNNING
         */

        private final int indentation;
        private final String entityId;
        private final Map<String, String> tagValues;

        private GameEntityLogEntry(final Builder builder) {
            this.indentation = builder.indentation;
            this.entityId = Objects.requireNonNull(builder.entityId, "builder.entityId");
            this.tagValues = Objects.requireNonNull(builder.tagValues, "builder.tagValues");
        }

        public int getIndentation() {
            return indentation;
        }

        public String getEntityId() {
            return entityId;
        }

        public String getTagValue(final String tag) {
            return tagValues.get(tag);
        }

        public Map<String, String> getTagValues() {
            return new HashMap<String, String>(tagValues);
        }

        public static class Builder {
            private int indentation;
            private String entityId;
            private final Map<String, String> tagValues = new HashMap<String, String>();

            public Builder indentation(final int indentation) {
                this.indentation = indentation;
                return this;
            }

            public Builder entityId(final String entityId) {
                this.entityId = Objects.requireNonNull(entityId, "entityId");
                return this;
            }

            public Builder addTagValuePair(final String tag, final String value) {
                Objects.requireNonNull(tag, "tag");
                Objects.requireNonNull(value, "value");
                tagValues.put(tag, value);
                return this;
            }

            public GameEntityLogEntry build() {
                return new GameEntityLogEntry(this);
            }
        }
    }

    /**
     * Entry for [Power] CREATE_GAME - Player.
     */
    public static class PlayerLogEntry implements LogEntry {
        /*
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
         */

        private final int indentation;
        private final String entityId;
        private final String playerId;
        private final GameAccountId gameAccountId;
        private final Map<String, String> tagValues;

        private PlayerLogEntry(final Builder builder) {
            this.indentation = builder.indentation;
            this.entityId = Objects.requireNonNull(builder.entityId, "builder.entityId");
            this.playerId = Objects.requireNonNull(builder.playerId, "builder.playerId");
            this.gameAccountId = Objects.requireNonNull(builder.gameAccountId, "builder.gameAccountId");
            this.tagValues = Objects.requireNonNull(builder.tagValues, "builder.tagValues");
        }

        public int getIndentation() {
            return indentation;
        }

        public String getEntityId() {
            return entityId;
        }

        public String getPlayerId() {
            return playerId;
        }

        public GameAccountId getGameAccountId() {
            return gameAccountId;
        }

        public String getTagValue(final String tag) {
            return tagValues.get(tag);
        }

        public Map<String, String> getTagValues() {
            return new HashMap<String, String>(tagValues);
        }

        public static class Builder {
            private int indentation;
            private String entityId;
            private String playerId;
            private GameAccountId gameAccountId;
            private final Map<String, String> tagValues = new HashMap<String, String>();

            public Builder indentation(final int indentation) {
                this.indentation = indentation;
                return this;
            }

            public Builder entityId(final String entityId) {
                this.entityId = Objects.requireNonNull(entityId, "entityId");
                return this;
            }

            public Builder playerId(final String playerId) {
                this.playerId = Objects.requireNonNull(playerId, "playerId");
                return this;
            }

            public Builder gameAccountId(final GameAccountId gameAccountId) {
                this.gameAccountId = Objects.requireNonNull(gameAccountId, "gameAccountId");
                return this;
            }

            public Builder addTagValuePair(final String tag, final String value) {
                Objects.requireNonNull(tag, "tag");
                Objects.requireNonNull(value, "value");
                tagValues.put(tag, value);
                return this;
            }

            public PlayerLogEntry build() {
                return new PlayerLogEntry(this);
            }
        }

        /**
         * Object for [Power] CREATE_GAME - Player - GameAccountId.
         */
        public static class GameAccountId implements LogObject {
            private final String hi;
            private final String lo;

            private GameAccountId(final Builder builder) {
                this.hi = Objects.requireNonNull(builder.hi, "builder.hi");
                this.lo = Objects.requireNonNull(builder.lo, "builder.lo");
            }

            public String getHi() {
                return hi;
            }

            public String getLo() {
                return lo;
            }

            public static class Builder {
                private String hi;
                private String lo;

                public Builder hi(final String hi) {
                    this.hi = Objects.requireNonNull(hi, "hi");
                    return this;
                }

                public Builder lo(final String lo) {
                    this.lo = Objects.requireNonNull(lo, "lo");
                    return this;
                }

                public GameAccountId build() {
                    return new GameAccountId(this);
                }
            }
        }
    }
}
