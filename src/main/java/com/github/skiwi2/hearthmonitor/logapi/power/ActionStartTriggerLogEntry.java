package com.github.skiwi2.hearthmonitor.logapi.power;

import com.github.skiwi2.hearthmonitor.logapi.LogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry for [POWER] ACTION_START SubType=TRIGGER
 *
 * @author Frank van Heeswijk
 */
public class ActionStartTriggerLogEntry implements LogEntry {
    /*
     * [Power] GameState.DebugPrintPower() - ACTION_START Entity=skiwi SubType=TRIGGER Index=-1 Target=0
     * [Power] GameState.DebugPrintPower() -     SHOW_ENTITY - Updating Entity=[id=33 cardId= type=INVALID zone=DECK zonePos=0 player=1] CardID=CS2_062
     * [Power] GameState.DebugPrintPower() -         tag=COST value=4
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=HAND
     * [Power] GameState.DebugPrintPower() -         tag=FACTION value=NEUTRAL
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=ABILITY
     * [Power] GameState.DebugPrintPower() -         tag=RARITY value=FREE
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[id=33 cardId= type=INVALID zone=DECK zonePos=0 player=1] tag=ZONE_POSITION value=2
     * [Power] GameState.DebugPrintPower() -     HIDE_ENTITY - Entity=[name=Dark Iron Dwarf id=27 zone=HAND zonePos=2 cardId=EX1_046 player=1] tag=ZONE value=DECK
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[name=Dark Iron Dwarf id=27 zone=HAND zonePos=2 cardId=EX1_046 player=1] tag=ZONE value=DECK
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[name=Dark Iron Dwarf id=27 zone=HAND zonePos=2 cardId=EX1_046 player=1] tag=ZONE_POSITION value=0
     * [Power] GameState.DebugPrintPower() -     SHOW_ENTITY - Updating Entity=[id=14 cardId= type=INVALID zone=DECK zonePos=0 player=1] CardID=GVG_096
     * [Power] GameState.DebugPrintPower() -         tag=HEALTH value=3
     * [Power] GameState.DebugPrintPower() -         tag=ATK value=4
     * [Power] GameState.DebugPrintPower() -         tag=COST value=4
     * [Power] GameState.DebugPrintPower() -         tag=ZONE value=HAND
     * [Power] GameState.DebugPrintPower() -         tag=CARDTYPE value=MINION
     * [Power] GameState.DebugPrintPower() -         tag=RARITY value=COMMON
     * [Power] GameState.DebugPrintPower() -         tag=DEATHRATTLE value=1
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[id=14 cardId= type=INVALID zone=DECK zonePos=0 player=1] tag=ZONE_POSITION value=3
     * [Power] GameState.DebugPrintPower() -     HIDE_ENTITY - Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE value=DECK
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE value=DECK
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE_POSITION value=0
     * [Power] GameState.DebugPrintPower() -     TAG_CHANGE Entity=skiwi tag=MULLIGAN_STATE value=WAITING
     * [Power] GameState.DebugPrintPower() - ACTION_END
     */

    private final int indentation;
    private final EntityLogObject entity;
    private final String subtype;
    private final String index;
    private final String target;
    private final List<LogEntry> logEntries;

    private ActionStartTriggerLogEntry(final Builder builder) {
        this.indentation = builder.indentation;
        this.entity = Objects.requireNonNull(builder.entity, "builder.entity");
        this.subtype = Objects.requireNonNull(builder.subtype, "builder.subtype");
        this.index = Objects.requireNonNull(builder.index, "builder.index");
        this.target = Objects.requireNonNull(builder.target, "builder.target");
        this.logEntries = Objects.requireNonNull(builder.logEntries, "builder.logEntries");
    }

    public int getIndentation() {
        return indentation;
    }

    public EntityLogObject getEntity() {
        return entity;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getIndex() {
        return index;
    }

    public String getTarget() {
        return target;
    }

    public List<LogEntry> getLogEntries() {
        return new ArrayList<LogEntry>(logEntries);
    }

    public static class Builder {
        private int indentation;
        private EntityLogObject entity;
        private String subtype;
        private String index;
        private String target;
        private final List<LogEntry> logEntries = new ArrayList<LogEntry>();

        public Builder indentation(final int indentation) {
            this.indentation = indentation;
            return this;
        }

        public Builder entity(final EntityLogObject entity) {
            this.entity = Objects.requireNonNull(entity, "entity");
            return this;
        }

        public Builder subtype(final String subtype) {
            this.subtype = Objects.requireNonNull(subtype, "subtype");
            return this;
        }

        public Builder index(final String index) {
            this.index = Objects.requireNonNull(index, "index");
            return this;
        }

        public Builder target(final String target) {
            this.target = Objects.requireNonNull(target, "target");
            return this;
        }

        public Builder addLogEntry(final LogEntry logEntry) {
            Objects.requireNonNull(logEntry, "logEntry");
            logEntries.add(logEntry);
            return this;
        }

        public ActionStartTriggerLogEntry build() {
            return new ActionStartTriggerLogEntry(this);
        }
    }
}
