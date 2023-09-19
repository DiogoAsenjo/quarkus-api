package br.com.treinos.repository;

import br.com.treinos.model.Treino;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class TreinosRepository implements PanacheMongoRepository<Treino> {

    public Response mostrarTreino(String id) {
        try {
            Treino treino = this.findById(new ObjectId(id));
            if (treino == null) {
                return Response
                        .noContent()
                        .build();
            }
            return Response
                    .ok(treino)
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID inválido")
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }
    }

    public Response mostrarTodosOsTreinos() {
        try {
            List<Treino> todosOsTreinos = this.listAll();
            return Response
                    .ok(todosOsTreinos)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }
    }

    public Response adicionarTreino(Treino treino) {
        try {
            this.persist(treino);
            return Response
                    .created(new URI("/" + treino.id))
                    .entity("Treino criado")
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }

    }

    public void atualizarTreino(String id, Treino treino) {
        treino.id = new ObjectId(id);
        this.update(treino);
    }

    public void excluirTreino(String id) {
        Treino treino = this.findById(new ObjectId(id));
        this.delete(treino);
    }
    public List<Treino> ordenar(String campo) {
        return listAll(Sort.descending(campo));
    }
}
