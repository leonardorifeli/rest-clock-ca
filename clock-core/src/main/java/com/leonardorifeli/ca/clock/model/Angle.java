package com.leonardorifeli.ca.clock.model;

public class Angle
{

    private final Double angle;

    public setAngle(Double angle)
    {
        this.angle = angle;
    }

    public Double getAngle()
    {
        return this.angle;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Angle angle = (Angle) o;

        return getAngle().equals(angle.getAngle());
    }

    @Override
    public int hashCode()
    {
        return getAngle().hashCode();
    }

    @Override
    public String toString()
    {
        return "Angle{angle="+this.angle+"}";
    }
}

