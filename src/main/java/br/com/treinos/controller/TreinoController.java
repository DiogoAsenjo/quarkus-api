package br.com.treinos.controller;

import br.com.treinos.model.Treino;
import br.com.treinos.repository.TreinosRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URISyntaxException;

@Path("/treinos")
@Tag(name = "Treinos", description = "Rotas relacionadas aos treinos")
public class TreinoController {

    @Inject
    TreinosRepository repository;

    @GET
    @Path("/{id}")
    @Operation(summary = "Busca um treino pelo id")
    public Response get(@PathParam("id") String id) {
       return repository.mostrarTreino(id);
    }

    @GET
    @Operation(summary = "Busca todos os treinos")
    public Response get() {
        return repository.mostrarTodosOsTreinos();
    }

    @GET
    @Path("/order/{campo}")
    @Operation(summary = "Ordena os treinos por um campo", description = "Ordena os treinos para saber os melhores de acordo com os seguintes campos: velocidadeMaxima, velocidadeMedia ou distanciaPercorrida")
    public Response search(@PathParam("campo") String campo) {
        return repository.ordenar(campo);
    }

    @GET
    @Path("/filtrar/{username}")
    @Operation(summary = "Filtra os treinos por usuário")
    public Response filter(@PathParam("username") String username) {
        return repository.mostrarTreinoUsuario(username);
    }

    @POST
    @Operation(summary = "Cria um novo treino")
    public Response create(@Valid Treino treino) throws URISyntaxException {
        return repository.adicionarTreino(treino);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Altera os dados de um treino", description = "Altera os dados de um treino existente de acordo com o id dele")
    public Response update(@PathParam("id") String id, @Valid Treino treino) {
        return repository.atualizarTreino(id, treino);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete um treino", description = "Delete um treino de acordo com o id dele")
    public Response delete(@PathParam("id") String id) {
        return repository.excluirTreino(id);
    }
}
