package com.leonardorifeli.ca.clock.api;

import com.leonardorifeli.ca.clock.model.Angle;
import com.leonardorifeli.ca.clock.model.Clock;
import com.leonardorifeli.ca.clock.util.DummyCache;
import com.leonardorifeli.ca.clock.util.DummyCacheProvider;
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
    private static final DummyCache<String, Clock> DUMMY_CACHE = DummyCacheProvider.getCache();

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

        final String key = this.getCacheKey(hour, minute);
        final Angle angle;

        if(DUMMY_CACHE.contains(key)) {
            angle = DUMMY_CACHE.get(key).getAngle();
            return getResponseWithFormat(angle.getAngle());
        }

        final Clock clock = new Clock(hour, minute);
        angle = clock.getAngle();

        LOG.debug("Angle for "+ clock + " is "+ angle.getAngle());
        DUMMY_CACHE.put(key, clock);

        return getResponseWithFormat(angle.getAngle());
    }

    private Response getResponseWithFormat(final double angle) {
        return Response.ok("{\"angle\":"+ String.format("%.0f", angle) +"}\n").build();
    }

    private final String getCacheKey(final Integer hour, final Integer minute) {
        return hour+":"+minute;
    }

}