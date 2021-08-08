package fr.snooker4real.englishbattlejo.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.Response;

public class JakartaEE9Resource {

    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
