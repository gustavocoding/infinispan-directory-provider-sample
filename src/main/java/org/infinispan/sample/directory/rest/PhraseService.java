package org.infinispan.sample.directory.rest;

import org.infinispan.sample.directory.domain.Phrase;
import org.infinispan.sample.directory.service.PersistenceService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/entities")
public class PhraseService {

   @Inject
   private PersistenceService persistenceService;

   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Phrase get(final @PathParam("id") int id) {
      return persistenceService.get(id);
   }

   @DELETE
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response delete(final @PathParam("id") int id) {
      persistenceService.deletePhrase(id);
      return Response.ok().build();
   }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response create(final Phrase phrase) {
      persistenceService.addPhrase(phrase);
      return Response.ok().build();
   }

   @PUT
   @Path("/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response update(final @PathParam("id") int id, final Phrase phrase) {
      persistenceService.update(id, phrase);
      return Response.ok().build();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response getAll() {
      return Response.ok(persistenceService.getAll()).build();
   }

   @GET
   @Path("/search")
   @Produces(MediaType.APPLICATION_JSON)
   public Response search(final @QueryParam("q") String luceneQuery) {
      return Response.ok(persistenceService.search(luceneQuery)).build();
   }

}
