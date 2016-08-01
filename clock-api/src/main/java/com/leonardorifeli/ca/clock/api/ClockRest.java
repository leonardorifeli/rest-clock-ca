package com.leonardorifeli.ca.clock.api;

import com.leonardorifeli.ca.clock.model.Angle;
import com.leonardorifeli.ca.clock.model.Clock;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/clock")
@Produces("application/json")
public class ClockRest {

    private static Logger LOG = LoggerFactory.getLogger(ClockRest.class);

    @GET
    @Path("/{hour}")
    @Formatted
    public Response getAngleForHour(final @PathParam("hour") Integer hour) {
        return getAngle(hour, 0);
    }

    @GET
    @Path("/{hour}/{minute}")
    @Formatted
    public Response getAngleForHourAndMinute(final @PathParam("hour") Integer hour, final @PathParam("minute") Integer minute) {
        return getAngle(hour, minute);
    }

    private Response getAngle(final Integer hour, final Integer minute) {
        if(hour < 0 || hour > 23) {
            LOG.warn("Invalid value for hour: "+ hour);
            return Response.status(400).build();
        }

        if(minute < 0 || minute > 59) {
            LOG.warn("Invalid value for minutes: "+ minute);
            return Response.status(400).build();
        }

        final Clock clock = new Clock(hour, minute);
        final Angle angle = clock.getAngle();

        LOG.debug("Angle for "+ clock + " is "+ angle.getAngle());

        return Response.ok(angle).build();
    }

}