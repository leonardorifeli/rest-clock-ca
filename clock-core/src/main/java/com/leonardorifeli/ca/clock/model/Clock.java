package com.leonardorifeli.ca.clock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class Clock {

    private Integer hour;
    private Integer minute;
    private Angle angle;
    private static Logger LOG = LoggerFactory.getLogger(Clock.class);

    public Clock(final Integer hour, final Integer minute) throws IllegalArgumentException {
        this.setHour(hour);
        this.setMinute(minute);
    }

    public void setHour(final Integer hour) throws IllegalArgumentException {
        if(hour == null || hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid value for hour.");
        }

        this.hour = (hour > 12) ? 12 - (24 - hour) : hour;
    }

    public void setMinute(final Integer minute) throws IllegalArgumentException {
        if(minute > 60 || minute < 0) {
            throw new IllegalArgumentException("Invalid value for minute.");
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

        Clock time = (Clock) o;

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
        if(this.angle != null) return this.angle;

        this.angle = new Angle(this.calculateDegrees());

        return this.angle;
    }

    private double calculateDegrees() throws IllegalArgumentException {
        if(this.getHour() == null)  {
            throw new IllegalArgumentException("Invalid hour.");
        }

        if(this.getMinute() == null)  {
            throw new IllegalArgumentException("Invalid minute.");
        }

        final double degrees = Math.abs((60 * this.getHour() - 11 * this.getMinute()) / 2.0);

        LOG.debug("Calculating angle for "+this+". Degrees: "+degrees);

        return validateDegrees(degrees);
    }

    private double validateDegrees(final double degrees) {
        if(degrees <= 180) return degrees;

        return (360 - degrees);
    }

}