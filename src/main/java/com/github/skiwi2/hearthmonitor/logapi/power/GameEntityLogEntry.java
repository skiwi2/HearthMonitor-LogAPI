package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Entry for [Power] CREATE_GAME - GameEntity.
 *
 * @author Frank van Heeswijk
 */
public class GameEntityLogEntry implements LogEntry {
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
