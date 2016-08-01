package com.leonardorifeli.ca.clock.model;

import com.leonardorifeli.ca.clock.model.Clock;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ClockTest
{
    @Test
    public void testValidHour() {
        try {
            Clock clock = new Clock(13, 0);

            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testValidMinute() {
        try {
            Clock clock = new Clock(13, 15);

            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testValidAngle() {
        assertTrue(true);
    }
}