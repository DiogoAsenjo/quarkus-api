package br.com.treinos.controller;

import br.com.treinos.model.Treino;
import br.com.treinos.repository.TreinosRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
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
    @APIResponse(responseCode = "200", description = "Retorna um treino baseado no ID que foi passado.")
    @APIResponse(responseCode = "404", description = "Informa se não existe um treino com aquele ID")
    @APIResponse(responseCode = "400", description = "Informa se algo está errado no ID")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response get(@PathParam("id") String id) {
       return repository.mostrarTreino(id);
    }

    @GET
    @Operation(summary = "Busca todos os treinos")
    @APIResponse(responseCode = "200", description = "Retorna todos os treinos cadastrados no sistema.")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response get() {
        return repository.mostrarTodosOsTreinos();
    }

    @GET
    @Path("/order/{campo}")
    @Operation(summary = "Ordena os treinos por um campo", description = "Ordena os treinos para saber os melhores de acordo com os seguintes campos: velocidadeMaxima, velocidadeMedia ou distanciaPercorrida")
    @APIResponse(responseCode = "200", description = "Retorna os treinos ordenados pelo campo selecionado, só podem ser escolhidos os campos: distanciaPercorrida, velocidadeMaxima e velocidadeMedia.")
    @APIResponse(responseCode = "404", description = "Informa se o campo selecionado não é válido")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response search(@PathParam("campo") String campo) {
        return repository.ordenar(campo);
    }

    @GET
    @Path("/filtrar/{username}")
    @Operation(summary = "Filtra os treinos por usuário")
    @APIResponse(responseCode = "200", description = "Retorna os treinos do usuário selecionado")
    @APIResponse(responseCode = "404", description = "Informa o username é inválido ou se ele não possui treinos")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response filter(@PathParam("username") String username) {
        return repository.mostrarTreinoUsuario(username);
    }

    @POST
    @Operation(summary = "Cria um novo treino")
    @APIResponse(responseCode = "201", description = "Cria um novo treino")
    @APIResponse(responseCode = "404", description = "Informa se o usuário não é válido")
    @APIResponse(responseCode = "400", description = "Diz se há algum problema em algum dos campos")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response create(@Valid Treino treino) throws URISyntaxException {
        return repository.adicionarTreino(treino);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Altera os dados de um treino", description = "Altera os dados de um treino existente de acordo com o id dele")
    @APIResponse(responseCode = "200", description = "Altera o treino selecionado")
    @APIResponse(responseCode = "404", description = "Informa se não existe um treino com aquele ID ou se o username não existe")
    @APIResponse(responseCode = "400", description = "Informa se algo está errado no ID ou com algum dos campos que serão alterados")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response update(@PathParam("id") String id, @Valid Treino treino) {
        return repository.atualizarTreino(id, treino);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete um treino", description = "Delete um treino de acordo com o id dele")
    @APIResponse(responseCode = "204", description = "Exclui o treino selecionado")
    @APIResponse(responseCode = "404", description = "Informa se não existe um treino com aquele ID")
    @APIResponse(responseCode = "400", description = "Informa se algo está errado no ID")
    @APIResponse(responseCode = "505", description = "Informa se houve algum erro interno no servidor")
    public Response delete(@PathParam("id") String id) {
        return repository.excluirTreino(id);
    }
}
