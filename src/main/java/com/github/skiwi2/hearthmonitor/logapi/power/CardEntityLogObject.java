package com.github.skiwi2.hearthmonitor.logapi.power;

/**
 * Object for [POWER] Entity=?, used for cards
 *
 * @author Frank van Heeswijk
 */
public class CardEntityLogObject implements EntityLogObject {
    /**
     * Supports the following cases:
     *  - [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE value=DECK
     *  - [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=[id=33 cardId= type=INVALID zone=DECK zonePos=0 player=1] tag=ZONE_POSITION value=2
     */

    private final String name;
    private final String id;
    private final String type;
    private final String zone;
    private final String zonePos;
    private final String cardId;
    private final String player;

    private CardEntityLogObject(final Builder builder) {
        this.name = Objects.requireNonNull(builder.name, "builder.name");
        this.id = Objects.requireNonNull(builder.id, "builder.id");
        this.type = Objects.requireNonNull(builder.type, "builder.type");
        this.zone = Objects.requireNonNull(builder.zone, "builder.zone");
        this.zonePos = Objects.requireNonNull(builder.zonePos, "builder.zonePos");
        this.cardId = Objects.requireNonNull(builder.cardId, "builder.cardId");
        this.player = Objects.requireNonNull(builder.player, "builder.player");
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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

    public String getCardId() {
        return cardId;
    }

    public String getPlayer() {
        return player;
    }

    public static class Builder {
        private String name = "";
        private String id;
        private String type = "";
        private String zone;
        private String zonePos;
        private String cardId = "";
        private String player;

        public Builder name(final String name) {
            this.name = Objects.requireNonNull(name, "name");
            return this;
        }

        public Builder id(final String id) {
            this.id = Objects.requireNonNull(id, "id");
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

        public Builder cardId(final String cardId) {
            this.cardId = Objects.requireNonNull(cardId, "cardId");
            return this;
        }

        public Builder player(final String player) {
            this.player = Objects.requireNonNull(player, "player");
            return this;
        }

        public CardEntityLogObject build() {
            return new CardEntityLogObject(this);
        }
    }
}
