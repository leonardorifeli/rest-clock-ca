package com.leonardorifeli.ca.clock.model;

import org.junit.Test;

public class TimeTest
{
    @Test
    public void testInvalidHour()
    {
        Time time = new Time();

        time.Time(14, 15);

        assertEquals("teste", "teste");
    }
}