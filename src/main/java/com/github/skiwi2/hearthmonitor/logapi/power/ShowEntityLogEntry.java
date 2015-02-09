package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Entry for [POWER] SHOW_ENTITY.
 *
 * @author Frank van Heeswijk
 */
public class ShowEntityLogEntry implements LogEntry {
    /**
     * [Power] GameState.DebugPrintPower() -     SHOW_ENTITY - Updating Entity=[id=33 cardId= type=INVALID zone=DECK zonePos=0 player=1] CardID=CS2_062
     * [Power] GameState.DebugPrintPower() -         tag=COST value=4
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=HAND
     * [Power] GameState.DebugPrintPower() -         tag=FACTION value=NEUTRAL
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=ABILITY
     * [Power] GameState.DebugPrintPower() -         tag=RARITY value=FREE
     */

    private final int indentation;
    private final EntityLogObject entity;
    private final String cardId;
    private final Map<String, String> tagValues;

    private ShowEntityLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.entity = Objects.requireNonNull(builder.entity, "builder.entity");
        this.cardId = Objects.requireNonNull(builder.cardId, "builder.cardId");
        this.tagValues = Objects.requireNonNull(builder.tagValues, "builder.tagValues");
    }

    public int getIndentation() {
        return indentation;
    }

    public EntityLogObject getEntity() {
        return entity;
    }

    public String getCardId() {
        return cardId;
    }

    public String getTagValue(final String tag) {
        return tagValues.get(tag);
    }

    public Map<String, String> getTagValues() {
        return new HashMap<String, String>(tagValues);
    }

    public static class Builder {
        private int indentation;
        private EntityLogObject entity;
        private String cardId;
        private final Map<String, String> tagValues = new HashMap<String, String>();

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder entity(final EntityLogObject entity) {
            this.entity = Objects.requireNonNull(entity, "entity");
            return this;
        }

        public Builder cardId(final String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId");
            return this;
        }

        public Builder addTagValuePair(final String tag, final String value) {
            Objects.requireNonNull(tag, "tag");
            Objects.requireNonNull(value, "value");
            tagValues.put(tag, value);
            return this;
        }

        public ShowEntityLogEntry build() {
            return new ShowEntityLogEntry(this);
        }
    }
}
