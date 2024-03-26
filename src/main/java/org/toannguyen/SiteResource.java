package org.toannguyen;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import static io.smallrye.config._private.ConfigLogging.log;

@ApplicationScoped
@Path("/sites")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SiteResource {
    @Inject
    SiteService siteService;

    @POST
    public Response create(@Valid SiteDTO siteDTO) {
        log.log(Logger.Level.DEBUG, "Creating...");
        siteService.create(siteDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{siteId}")
    public Response edit(@Valid SiteDTO siteDTO, @PathParam("siteId") Long siteId) {
        siteService.edit(siteDTO, siteId);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{siteId}")
    public Response delete(@PathParam("siteId") Long siteId) {
        siteService.delete(siteId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{siteId}")
    public Response get(@PathParam("siteId") Long siteId) {
        var site = siteService.get(siteId);
        return Response.ok(site).build();
    }

    @GET
    public Response getAll() {
        var sites = siteService.getAll();
        return Response.ok(sites).build();
    }
}
