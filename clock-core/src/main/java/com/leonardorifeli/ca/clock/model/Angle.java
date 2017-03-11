package com.leonardorifeli.ca.clock.model;

public class Angle {

    private final Double angle;

    public Angle(Double angle) {
        this.angle = angle;
    }

    public Double getAngle() {
        return this.angle;
    }

    @Override
    public String toString() {
        return "Angle{angle=" + this.angle + "}";
    }
}

