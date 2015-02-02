package com.github.skiwi2.hearthmonitor.logapi.zone;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

/**
 * Entry for [Zone] TRANSITIONING.
 *
 * @author Frank van Heeswijk
 */
public class TransitioningLogEntry implements LogEntry {
    /*
     * [Zone] ZoneChangeList.ProcessChanges() - TRANSITIONING card [name=Gul'dan id=4 zone=PLAY zonePos=0 cardId=HERO_07 player=1] to FRIENDLY PLAY (Hero)
     */

    private final int indentation;
    private final String name;
    private final String id;
    private final String zone;
    private final String zonePos;
    private final String cardId;
    private final String player;
    private final String targetZone;

    private TransitioningLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.name = Objects.requireNonNull(builder.name, "builder.name");
        this.id = Objects.requireNonNull(builder.id, "builder.id");
        this.zone = Objects.requireNonNull(builder.zone, "builder.zone");
        this.zonePos = Objects.requireNonNull(builder.zonePos, "builder.zonePos");
        this.cardId = Objects.requireNonNull(builder.cardId, "builder.cardId");
        this.player = Objects.requireNonNull(builder.player, "builder.player");
        this.targetZone = Objects.requireNonNull(builder.targetZone, "builder.targetZone");
    }

    public int getIndentation() {
        return indentation;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getZone() {
        return zone;
    }

    public String getZonePos() {
        return zonePos;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPlayer() {
        return player;
    }

    public String getTargetZone() {
        return targetZone;
    }

    public static class Builder {
        private int indentation;
        private String name;
        private String id;
        private String zone;
        private String zonePos;
        private String cardId;
        private String player;
        private String targetZone;

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder name(final String name) {
            this.name = Objects.requireNonNull(name, "name");
            return this;
        }

        public Builder id(final String id) {
            this.id = Objects.requireNonNull(id, "id");
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

        public Builder cardId(final String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId");
            return this;
        }

        public Builder player(final String player) {
            this.player = Objects.requireNonNull(player, "player");
            return this;
        }

        public Builder targetZone(final String targetZone) {
            this.targetZone = Objects.requireNonNull(targetZone, "targetZone");
            return this;
        }

        public TransitioningLogEntry build() {
            return new TransitioningLogEntry(this);
        }
    }
}
