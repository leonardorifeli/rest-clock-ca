package com.leonardorifeli.ca.clock;

public class Angle {
    private final Double angle;

    public setAngle(Double angle) {
        this.angle = angle;
    }

    public Double getAngle() {
        return this.angle;
    }

    @Override
    public boolean equals(Object alfa) {
        if (this == alfa) return true;
        if (alfa == null || getClass() != alfa.getClass()) return false;

        Angle angle = (Angle) alfa;

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

