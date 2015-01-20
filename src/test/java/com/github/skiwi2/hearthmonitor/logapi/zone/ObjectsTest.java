package com.github.skiwi2.hearthmonitor.logapi.zone;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ObjectsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRequireNonNullObjectNotNull() {
        assertEquals("test", Objects.requireNonNull("test", "testmessage"));
    }

    @Test
    public void testRequireNonNullObjectNull() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("testmessage");
        Objects.requireNonNull(null, "testmessage");
    }
}