package br.com.treinos.controller;

import br.com.treinos.model.Treino;
import br.com.treinos.repository.TreinosRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
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
       return repository.mostrarTreino(id);
    }

    @GET
    public Response get() {
        return repository.mostrarTodosOsTreinos();
    }

    @GET
    @Path("/order/{campo}")
    public Response search(@PathParam("campo") String campo) {
        List<Treino> treinosOrdenados = repository.ordenar(campo);
        return Response.ok(treinosOrdenados).build();
    }

    @POST
    public Response create(@Valid Treino treino) throws URISyntaxException {
        return repository.adicionarTreino(treino);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, @Valid Treino treino) {
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
