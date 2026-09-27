package org.example.restdemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Arrays;
import java.util.List;

@Path("/aliens")
public class AlienResource
{
    @GET
    // @Produces(MediaType.APPLICATION_JSON) not mandatory.
    public List<Alien> getAliens()
    {
        System.out.println("getAlien called.");

        Alien a1=new Alien();
        a1.setName("Parul");
        a1.setPoints(98);

        Alien a2=new Alien();
        a2.setName("Payal");
        a2.setPoints(90);

        List<Alien> aliens= Arrays.asList(a1,a2);

        return aliens;
    }
}
