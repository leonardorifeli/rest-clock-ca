package com.leonardorifeli.ca.clock.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class Clock {

	private Integer hour;
	private Integer minute;
	private Angle angle;
	private static int COMPLETE_CIRCLE_DEGREES = 360;
	private static Logger LOG = LoggerFactory.getLogger(Clock.class);

	public Clock(final Integer hour, final Integer minute) throws IllegalArgumentException {
		setHour(hour);
		setMinute(minute);
	}

	public void setHour(final Integer hour) throws IllegalArgumentException {
		if(hour == null || hour < 0 || hour > 23)
			throw new IllegalArgumentException("Invalid value for hour.");

		this.hour = getValidatedHour(hour);
	}

	public void setMinute(final Integer minute) throws IllegalArgumentException {
		if(minute == null || minute > 59 || minute < 0)
			throw new IllegalArgumentException("Invalid value for minute.");

		this.minute = (minute == null) ? 0 : minute;
	}

	public Integer getHour() {
		return hour;
	}

	public Integer getMinute() {
		return minute;
	}

	@Override
	public String toString() {
		return "Time{hour=" + this.hour + ", minutes=" + this.minute + "}";
	}

	public Angle getAngle() {
		if(this.angle != null)
			return this.angle;

		this.angle = new Angle(this.calculateDegrees());

		return this.angle;
	}

	private Integer getValidatedHour(Integer hour) {
		return (hour > 12) ? 12 - (24 - hour) : hour;
	}

	private Integer getCalculatedHour(Integer hour) {
		return 12 - (24 - hour);
	}

	private double calculateDegrees() {
		LOG.debug("Calculating angle for "+this+". Degrees: "+degrees);
		final double degrees = Math.abs(expressionToDegrees(this.getHour(), this.getMinute()));
		return validateDegrees(degrees);
	}

	private double getExpressionToDegrees(hour, minute) {
		return (60 * hour - 11 * minute) / 2.0;
	}

	private double validateDegrees(final double degrees) {
		if(degrees <= (COMPLETE_CIRCLE_DEGREES/2))
			return degrees;
		return (COMPLETE_CIRCLE_DEGREES - degrees);
	}

}
