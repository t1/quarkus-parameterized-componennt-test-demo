package com.github.t1;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/hello")
public class GreetingsRestController {

    @Inject GreetingsService greetings;

    @GET
    @Produces(TEXT_PLAIN)
    public String hello() {
        return greetings.greeting() + " REST";
    }
}
