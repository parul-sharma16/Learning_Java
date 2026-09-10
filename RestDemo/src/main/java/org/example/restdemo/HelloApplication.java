package org.example.restdemo;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        packages("org.example.restdemo");
    }

}