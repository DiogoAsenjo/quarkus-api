package br.com.treinos.controller;

import br.com.treinos.model.Treino;
import br.com.treinos.repository.TreinosRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/treinos")
public class TreinoController {

    @Inject
    TreinosRepository repository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        Treino treino = repository.mostrarTreino(id);
        return Response.ok(treino).build();
    }

    @GET
    public Response get() {
        List<Treino> todosOsTreinos = repository.mostrarTodosOsTreinos();
        return Response.ok(todosOsTreinos).build();
    }

    @POST
    public Response create(Treino treino) throws URISyntaxException {
        repository.adicionarTreino(treino);
        return Response.created(new URI("/" + treino.id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Treino treino) {
        repository.atualizarTreino(id, treino);
        return Response.ok(treino).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        repository.excluirTreino(id);
        return Response.noContent().build();
    }
}
