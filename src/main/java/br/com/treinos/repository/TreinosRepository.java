package br.com.treinos.repository;

import br.com.atletas.model.Atleta;
import br.com.atletas.repository.AtletasRepository;
import br.com.treinos.model.Treino;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class TreinosRepository implements PanacheMongoRepository<Treino> {

    @Inject
    AtletasRepository atletasrepository;

    public Response mostrarTreino(String id) {
        try {
            Treino treino = this.findById(new ObjectId(id));
            if (treino == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Treino não existe!")
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

    public Response mostrarTreinoUsuario(String username) {
        try {
            Atleta usernameExiste = atletasrepository.verificaSeContaJaExisteUsername(username);
            if (usernameExiste == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Username inválido!")
                        .build();
            }
            List<Treino> treinosUsuario = list("username", username);
            if (treinosUsuario == null || treinosUsuario.isEmpty()) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Nenhum treino desse usuário")
                        .build();
            }
                return Response
                    .ok(treinosUsuario)
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
            Atleta usernameExiste = atletasrepository.verificaSeContaJaExisteUsername(treino.getUsername());
            if (usernameExiste == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Username inválido!")
                        .build();
            }
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

    public Response atualizarTreino(String id, Treino treino) {
        try {
            Atleta usernameExiste = atletasrepository.verificaSeContaJaExisteUsername(treino.getUsername());
            if (usernameExiste == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Username inválido!")
                        .build();
            }
            treino.id = new ObjectId(id);
            Treino treinoExiste = this.findById(treino.id);
            if (treinoExiste == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Treino não existe!")
                        .build();
            }
            this.update(treino);
            return Response
                    .ok(treino)
                    .entity("Treino modificado!")
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

    public Response excluirTreino(String id) {
        try {
            Treino treino = this.findById(new ObjectId(id));
            if (treino == null) {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Treino não existe")
                        .build();
            }
            this.delete(treino);
            return Response
                    .noContent()
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

    public Response ordenar(String campo) {
        try {
            if (!campo.equals("distanciaPercorrida") &&
                !campo.equals("velocidadeMaxima") &&
                !campo.equals("velocidadeMedia"))
            {
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Campo inválido, digite 'velocidadeMedia', 'velocidadeMaxima' ou 'distanciaPercorrida'")
                        .build();
            }
            List<Treino> treinosOrdenados = this.listAll(Sort.descending(campo));
            return Response
                    .ok(treinosOrdenados)
                    .build();
        }  catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno do servidor")
                    .build();
        }
    }
}
