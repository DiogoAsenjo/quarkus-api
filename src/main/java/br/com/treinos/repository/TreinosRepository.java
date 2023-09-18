package br.com.treinos.repository;

import br.com.treinos.model.Treino;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TreinosRepository implements PanacheMongoRepository<Treino> {

    public Treino acharPelaData(String data) {
        return find("data", data).firstResult();
    }

    public List<Treino> ordenarPelaData() {
        return listAll(Sort.by("data"));
    }
}
