package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

/**
 * Entry for [POWER] HIDE_ENTITY.
 *
 * @author Frank van Heeswijk
 */
public class HideEntityLogEntry implements LogEntry {
    /**
     * [Power] GameState.DebugPrintPower() -     HIDE_ENTITY - Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE value=DECK
     */

    private final int indentation;
    private final EntityLogObject entity;
    private final String tag;
    private final String value;

    private HideEntityLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.entity = Objects.requireNonNull(builder.entity, "builder.entity");
        this.tag = Objects.requireNonNull(builder.tag, "builder.tag");
        this.value = Objects.requireNonNull(builder.value, "builder.value");
    }

    public int getIndentation() {
        return indentation;
    }

    public EntityLogObject getEntity() {
        return entity;
    }

    public String getTag() {
        return tag;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {
        private int indentation;
        private EntityLogObject entity;
        private String tag;
        private String value;

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder entity(final EntityLogObject entity) {
            this.entity = Objects.requireNonNull(entity, "entity");
            return this;
        }

        public Builder tag(final String tag) {
            this.tag = Objects.requireNonNull(tag, "tag");
            return this;
        }

        public Builder value(final String value) {
            this.value = Objects.requireNonNull(value, "value");
            return this;
        }

        public HideEntityLogEntry build() {
            return new HideEntityLogEntry(this);
        }
    }
}
