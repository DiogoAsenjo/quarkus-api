package org.acme.treinos;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TreinosRepository implements PanacheMongoRepository<Treinos> {

    public Treinos acharPelaData(String data) {
        return find("data", data).firstResult();
    }

    public List<Treinos> ordenarPelaData() {
        return listAll(Sort.by("data"));
    }
}
