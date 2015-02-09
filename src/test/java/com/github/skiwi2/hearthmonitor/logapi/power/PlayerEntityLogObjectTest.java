package com.github.skiwi2.hearthmonitor.logapi.power;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerEntityLogObjectTest {
    @Test
    public void testPlayerEntity() {
        PlayerEntityLogObject playerEntityLogObject = new PlayerEntityLogObject.Builder()
            .name("skiwi")
            .build();
        assertEquals("skiwi", playerEntityLogObject.getName());
    }
}