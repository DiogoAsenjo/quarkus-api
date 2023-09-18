package br.com.treinos.repository;

import br.com.treinos.model.Treino;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class TreinosRepository implements PanacheMongoRepository<Treino> {

    public Treino mostrarTreino(String id) {
        return this.findById(new ObjectId(id));
    }

    public List<Treino> mostrarTodosOsTreinos() {
        return this.listAll();
    }

    public void adicionarTreino(Treino treino) {
        this.persist(treino);
    }

    public void atualizarTreino(String id, Treino treino) {
        treino.id = new ObjectId(id);
        this.update(treino);
    }

    public void excluirTreino(String id) {
        Treino treino = this.findById(new ObjectId(id));
        this.delete(treino);
    }
    public Treino acharPelaData(String data) {
        return find("data", data).firstResult();
    }

    public List<Treino> ordenarPelaData() {
        return listAll(Sort.by("data"));
    }
}
