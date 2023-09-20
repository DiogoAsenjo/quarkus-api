package br.com.atletas.repository;

import br.com.atletas.model.Atleta;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@ApplicationScoped
public class AtletasRepository implements PanacheMongoRepository<Atleta> {
    public Atleta verificaSeContaJaExisteEmail(String email) {
        return this.find("email", email).firstResult();
    }

    public Atleta verificaSeContaJaExisteUsername(String username) {
        return this.find("username", username).firstResult();
    }

    public Response criarConta(Atleta novoAtleta) {
        try {
            Atleta contaExiste = this.verificaSeContaJaExisteEmail(novoAtleta.getEmail());
            if (contaExiste != null) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity("Conta já existente, use outro email")
                        .build();
            }
            this.persist(novoAtleta);
            return Response
                    .created(new URI("/" + novoAtleta.id))
                    .entity("Conta criada")
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }
    }

    public Response fazerLogin(String email, String senha) {
        try {
            Atleta contaExiste = this.verificaSeContaJaExisteEmail(email);
            if (contaExiste == null) {
                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity("Email não existe!")
                        .build();
            }
            if (!(contaExiste.getSenha().equals(senha))) {
                return Response
                        .status(Response.Status.UNAUTHORIZED)
                        .entity("Senha incorreta")
                        .build();
            }
            return Response
                    .status(Response.Status.OK)
                    .entity("Usuário logado")
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }
    }

}
