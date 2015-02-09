package com.github.skiwi2.hearthmonitor.logapi.zone;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;
import com.github.skiwi2.hearthmonitor.logapi.power.EntityLogObject;

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
    private final EntityLogObject entity;
    private final String targetZone;

    private TransitioningLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.entity = Objects.requireNonNull(builder.entity, "builder.entity");
        this.targetZone = Objects.requireNonNull(builder.targetZone, "builder.targetZone");
    }

    public int getIndentation() {
        return indentation;
    }

    public EntityLogObject getEntity() {
        return entity;
    }

    public String getTargetZone() {
        return targetZone;
    }

    public static class Builder {
        private int indentation;
        private EntityLogObject entity;
        private String targetZone;

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder entity(final EntityLogObject entity) {
            this.entity = Objects.requireNonNull(entity, "entity");
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
