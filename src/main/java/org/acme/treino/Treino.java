package org.acme.treino;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import jakarta.json.bind.annotation.JsonbCreator;

public class Treino extends PanacheMongoEntity {
    //ATRIBUTOS
//    private
    String data;
    private String tempoGasto;
    private double distanciaPercorrida;
    private double velocidadeMaxima;
    private double velocidadeMedia;

    //CONSTRUTOR
    public Treino() {

    }

    public Treino(String data, String tempoGasto, double distanciaPercorrida, double velocidadeMaxima, double velocidadeMedia) {
        this.data = data;
        this.tempoGasto = tempoGasto;
        this.distanciaPercorrida = distanciaPercorrida;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeMedia = velocidadeMedia;
    }

    //GETTERS E SETTERS

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(String tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }
}
