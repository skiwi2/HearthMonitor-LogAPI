package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

/**
 * Entry for [Power] TAG_CHANGE.
 *
 * @author Frank van Heeswijk
 */
public class TagChangeLogEntry implements LogEntry {
    /*
     * [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=skiwi tag=TIMEOUT value=75
     */

    private final String entity;
    private final String tag;
    private final String value;

    private TagChangeLogEntry(final Builder builder) {
        this.entity = Objects.requireNonNull(builder.entity, "builder.entity");
        this.tag = Objects.requireNonNull(builder.tag, "builder.tag");
        this.value = Objects.requireNonNull(builder.value, "builder.value");
    }

    public String getEntity() {
        return entity;
    }

    public String getTag() {
        return tag;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {
        private String entity;
        private String tag;
        private String value;

        public Builder entity(final String entity) {
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

        public TagChangeLogEntry build() {
            return new TagChangeLogEntry(this);
        }
    }
}
