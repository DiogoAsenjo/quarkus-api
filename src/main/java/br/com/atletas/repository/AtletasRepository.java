package br.com.atletas.repository;

import br.com.atletas.model.Atleta;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@ApplicationScoped
public class AtletasRepository implements PanacheMongoRepository<Atleta> {
    public Response criarConta(Atleta novoAtleta) {
        try{
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
}
