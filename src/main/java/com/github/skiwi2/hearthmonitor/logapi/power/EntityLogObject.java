package com.github.skiwi2.hearthmonitor.logapi.power;

/**
 * Interface for [POWER} Entity=? object
 *
 * @author Frank van Heeswijk
 */
public interface EntityLogObject {
    /**
     * Examples of supported cases:
     *  - [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=skiwi tag=MULLIGAN_STATE value=WAITING
     *  - [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=[name=Dread Infernal id=34 zone=HAND zonePos=3 cardId=CS2_064 player=1] tag=ZONE value=DECK
     *  - [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=[id=33 cardId= type=INVALID zone=DECK zonePos=0 player=1] tag=ZONE_POSITION value=2
     */
}
