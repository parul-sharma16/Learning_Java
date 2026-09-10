package org.example.restdemo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}

/*
REST API built with Jersey. It exposes a GET /api/hello-world endpoint, which is implemented by HelloResource.

HelloApplication configures Jersey →
Jersey routes HTTP requests →
HelloResource handles the endpoint →
hello() produces the response.

| Thing                        | In this demo           |
| ---------------------------- | ---------------------- |
| Web server                   | Tomcat                 |
| REST framework               | Jersey                 |
| Jersey configuration         | HelloApplication       |
| REST resource class          | HelloResource          |
| API endpoint                 | GET /api/hello-world   |
| HTTP method                  | GET                    |
| Java method handling request | hello()                |
| Response                     | "Hello, World!"        |

 */