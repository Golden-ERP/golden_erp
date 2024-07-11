package com.goldenconsultingci.erp.identityaccess.presentation.resource;

import com.goldenconsultingci.erp.identityaccess.application.representation.AccessTokenRepresentation;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("/aim")
public class JerseyResource extends AbstractResource{

    @POST
    @Path("/login")
    public Response login(String username, String password) {
        String token = this.identityApplicationService()
                .authenticate(username, password);

        if(token == null) {
            throw new WebApplicationException(
                    Response.status(404).build());
        }
        return Response.status(201)
                .entity(new AccessTokenRepresentation(token, "Bearer"))
                .build();

    }

}
