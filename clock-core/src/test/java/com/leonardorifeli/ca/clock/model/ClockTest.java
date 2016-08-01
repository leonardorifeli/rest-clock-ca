package com.leonardorifeli.ca.clock.model;

import com.leonardorifeli.ca.clock.model.Clock;
import com.leonardorifeli.ca.clock.model.Angle;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ClockTest {

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
    public void testAngle() {
        Clock clock = new Clock(3, 0);

        Angle angle = clock.getAngle();

        assertEquals(90.0, angle.getAngle());
    }

    @Test
    public void testZeroAngle() {
        Clock clock = new Clock(12, 0);

        Angle angle = clock.getAngle();

        assertEquals(0.0, angle.getAngle());
    }

    @Test
    public void testInvalidHour() {
        try {
            Clock clock = new Clock(24, 0);

            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidMinute() {
        try {
            Clock clock = new Clock(23, 59);

            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

}