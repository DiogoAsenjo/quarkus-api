package org.acme.treino;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Treino extends PanacheMongoEntity {
    //ATRIBUTOS
    String data;
    String tempoGasto;
    double distanciaPercorrida;
    double velocidadeMaxima;
    double velocidadeMedia;

    //CONSTRUTOR
    public Treino(String data, String tempoGasto, double distanciaPercorrida, double velocidadeMaxima, double velocidadeMedia) {
        this.data = data;
        this.tempoGasto = tempoGasto;
        this.distanciaPercorrida = distanciaPercorrida;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeMedia = velocidadeMedia;
    }
}
