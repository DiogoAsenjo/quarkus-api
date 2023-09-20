package br.com.atletas.controller;

import br.com.atletas.dto.LoginDTO;
import br.com.atletas.model.Atleta;
import br.com.atletas.repository.AtletasRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URISyntaxException;

@Path("/atletas")
@Tag(name = "Atletas", description = "Rotas relacionadas aos atletas")
public class AtletaController {

    @Inject
    AtletasRepository repository;

    @POST
    @Operation(summary = "Cria conta de um novo atleta")
    public Response create(@Valid Atleta novoAtleta)
     throws URISyntaxException {
        return repository.criarConta(novoAtleta);
    }

    @POST
    @Path("/login")
    @Operation(summary = "Faz login na conta")
    public Response login(@Valid LoginDTO user) {
        String email = user.getEmail();
        String senha = user.getSenha();

        return repository.fazerLogin(email, senha);
    }
}
