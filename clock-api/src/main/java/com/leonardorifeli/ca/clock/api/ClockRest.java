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
    
}