package com.github.skiwi2.hearthmonitor.logapi.power;

/**
 * Object for [POWER] Entity=?, used for players.
 *
 * @author Frank van Heeswijk
 */
public class PlayerEntityLogObject implements EntityLogObject {
    /**
     * [Power] GameState.DebugPrintPower() - TAG_CHANGE Entity=skiwi tag=MULLIGAN_STATE value=WAITING
     */

    private final String name;

    private PlayerEntityLogObject(final Builder builder) {
        this.name = Objects.requireNonNull(builder.name, "builder.name");
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private String name;

        public Builder name(final String name) {
            this.name = Objects.requireNonNull(name, "name");
            return this;
        }

        public PlayerEntityLogObject build() {
            return new PlayerEntityLogObject(this);
        }
    }
}
