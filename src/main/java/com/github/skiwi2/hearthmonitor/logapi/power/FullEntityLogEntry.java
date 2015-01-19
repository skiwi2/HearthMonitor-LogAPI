package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Entry for [Power] FULL_ENTITY
 *
 * @author Frank van Heeswijk
 */
public class FullEntityLogEntry implements LogEntry {
    /*
     * [Power] GameState.DebugPrintPower() - FULL_ENTITY - Creating ID=4 CardID=HERO_07
     * [Power] GameState.DebugPrintPower() -     tag=HEALTH value=30
     * [Power] GameState.DebugPrintPower() -     tag=ZONE value=PLAY
     * [Power] GameState.DebugPrintPower() -     tag=CONTROLLER value=1
     * [Power] GameState.DebugPrintPower() -     tag=ENTITY_ID value=4
     * [Power] GameState.DebugPrintPower() -     tag=FACTION value=NEUTRAL
     * [Power] GameState.DebugPrintPower() -     tag=CARDTYPE value=HERO
     * [Power] GameState.DebugPrintPower() -     tag=RARITY value=FREE
     */

    private final String id;
    private final String cardId;
    private final Map<String, String> tagValues;

    private FullEntityLogEntry(final Builder builder) {
        this.id = builder.id;
        this.cardId = builder.cardId;
        this.tagValues = builder.tagValues;
    }

    public String getId() {
        return id;
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
        private String id;
        private String cardId;
        private final Map<String, String> tagValues = new HashMap<String, String>();

        public Builder id(final String id) {
            this.id = Objects.requireNonNull(id, "id");
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

        public FullEntityLogEntry build() {
            return new FullEntityLogEntry(this);
        }
    }
}
