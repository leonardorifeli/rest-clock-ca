package com.leonardorifeli.ca.clock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Time {

    private Integer hour;
    private Integer minute;
    private Angle angle;

    public Time(final Integer hour) throws IllegalArgumentException {
        this.setHour(hour);
        this.setMinute(minute);
    }

    public void setHour(final Integer hour) throws IllegalArgumentException {
        if(hour == null || hour < 0) {
            throw new IllegalArgumentException("Invalid value for hour.");
        }

        this.hour = (hour > 12) ? 12 - (24 - hour) : hour;
    }

    public void setMinute(final Integer minute) throws IllegalArgumentException {
        if(minute > 60 || minute < 0) {
            throw new IllegalArgumentException("Invalud value for minute.");
        }

        this.minute = (minute == null) ? 0 : minute;
    }

    public Integer getHour() {
        return this.hour;
    }

    public Integer getMinute() {
        return this.minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (!getHour().equals(time.getHour())) return false;

        return getMinute().equals(time.getMinute());
    }

    @Override
    public int hashCode() {
        int result = getHour().hashCode();

        result = 31 * result + getMinute().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Time{hour=" + this.hour + ", minutes=" + this.minute + "}";
    }

    public Angle getAngle() {
        return this.angle;
    }

}