package com.leonardorifeli.ca.clock.model;

import com.leonardorifeli.ca.clock.model.Time;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TimeTest
{
    @Test
    public void testValidHour() {
        try {
            Time time = new Time(13, 0);

            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testValidMinute() {
        try {
            Time time = new Time(13, 15);

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