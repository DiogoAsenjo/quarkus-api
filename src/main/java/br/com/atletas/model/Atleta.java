package br.com.atletas.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@MongoEntity(collection = "atletas")
public class Atleta extends PanacheMongoEntity {
    //ATRIBUTOS
    @NotBlank(message = "O campo username é obrigatório")
    private String username;
    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "O campo email deve conter um email")
    private String email;
    @NotBlank(message = "O campo senha é obrigatório")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    private String senha;

    //CONSTRUTOR
    public Atleta() {

    }
    public Atleta(String username, String email, String senha) {
        this.username = username;
        this.email = email;
        this.senha = senha;
    }

    //GETTERS E SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
