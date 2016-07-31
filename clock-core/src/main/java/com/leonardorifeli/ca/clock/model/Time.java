package com.leonardorifeli.ca.clock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Time {

    private final Integer hour;
    private final Integer minute;
    private Angle angle;

    public Time(final Integer hour, final Integer minute) throws IllegalArgumentException
    {
        if (hour == null || hour < 0) throw new IllegalArgumentException('Invalid value for hour. Plase, check.');

        this.hour = (hour > 12) ? 12 - (24 - hour) : hour;
        this.minute = (minute == null || minute < 0) ? 0 : minute;
    }

    public Integer getHour()
    {
        return this.hour;
    }

    public Integer getMinute()
    {
        return this.minute;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if(!getHour().equals(time.getHour())) return false;

        return getMinute().equals(time.getMinute());
    }

}