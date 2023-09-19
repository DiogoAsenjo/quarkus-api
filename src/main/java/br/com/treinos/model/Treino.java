package br.com.treinos.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "treinos")
public class Treino extends PanacheMongoEntity {
    //ATRIBUTOS
    @NotBlank(message = "Data deve conter algum valor")
    private String data;
    @NotBlank(message = "Tempo gasto deve conter algum valor")
    private String tempoGasto;
    @Positive(message = "A distância deve ser maior que 0")
    private double distanciaPercorrida;
    @Positive(message = "A velocidade máxima deve ser maior que 0")
    private double velocidadeMaxima;
    @Positive(message = "A velocidade média deve ser maior que 0")
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
