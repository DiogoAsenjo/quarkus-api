package br.com.treinos.controller;

import br.com.treinos.model.Treino;
import br.com.treinos.repository.TreinosRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.net.URI;
import java.net.URISyntaxException;

@Path("/treinos")
public class TreinoController {

    @Inject
    TreinosRepository repository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        Treino treino = repository.findById(new ObjectId(id));
        return Response.ok(treino).build();
    }

    @GET
    public Response get() {
        return Response.ok(repository.listAll()).build();
    }

    @POST
    public Response create(Treino treino) throws URISyntaxException {
        repository.persist(treino);
        return Response.created(new URI("/" + treino.id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Treino treino) {
        treino.id = new ObjectId(id);
        repository.update(treino);
        return Response.ok(treino).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Treino treino = repository.findById(new ObjectId(id));
        repository.delete(treino);
        return Response.noContent().build();
    }

}
