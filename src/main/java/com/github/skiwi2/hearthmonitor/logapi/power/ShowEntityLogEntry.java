package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Entry for [POWER] SHOW_ENTITY
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
    private final String id;
    private final String cardId;
    private final String type;
    private final String zone;
    private final String zonePos;
    private final String player;
    private final String showCardId;
    private final Map<String, String> tagValues;

    private ShowEntityLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.id = Objects.requireNonNull(builder.id, "builder.id");
        this.cardId = Objects.requireNonNull(builder.cardId, "builder.cardId");
        this.type = Objects.requireNonNull(builder.type, "builder.type");
        this.zone = Objects.requireNonNull(builder.zone, "builder.zone");
        this.zonePos = Objects.requireNonNull(builder.zonePos, "builder.zonePos");
        this.player = Objects.requireNonNull(builder.player, "builder.player");
        this.showCardId = Objects.requireNonNull(builder.showCardId, "builder.showCardId");
        this.tagValues = Objects.requireNonNull(builder.tagValues, "builder.tagValues");
    }

    public int getIndentation() {
        return indentation;
    }

    public String getId() {
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public String getType() {
        return type;
    }

    public String getZone() {
        return zone;
    }

    public String getZonePos() {
        return zonePos;
    }

    public String getPlayer() {
        return player;
    }

    public String getShowCardId() {
        return showCardId;
    }

    public String getTagValue(final String tag) {
        return tagValues.get(tag);
    }

    public Map<String, String> getTagValues() {
        return new HashMap<String, String>(tagValues);
    }

    public static class Builder {
        private int indentation;
        private String id;
        private String cardId;
        private String type;
        private String zone;
        private String zonePos;
        private String player;
        private String showCardId;
        private final Map<String, String> tagValues = new HashMap<String, String>();

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder id(final String id) {
            this.id = Objects.requireNonNull(id, "id");
            return this;
        }

        public Builder cardId(final String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId");
            return this;
        }

        public Builder type(final String type) {
            this.type = Objects.requireNonNull(type, "type");
            return this;
        }

        public Builder zone(final String zone) {
            this.zone = Objects.requireNonNull(zone, "zone");
            return this;
        }

        public Builder zonePos(final String zonePos) {
            this.zonePos = Objects.requireNonNull(zonePos, "zonePos");
            return this;
        }

        public Builder player(final String player) {
            this.player = Objects.requireNonNull(player, "player");
            return this;
        }

        public Builder showCardId(final String showCardId) {
            this.showCardId = Objects.requireNonNull(showCardId, "showCardId");
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
