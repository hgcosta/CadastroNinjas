package dev.hugocosta.CadastroNinjas;

// É preciso transofrmar a classe model em entidades

import jakarta.persistence.*;

//JPA = Java Persistence API
//@Entity transforma toda a classe em uma entidade do banco de dados falando a table com a coluna de cada argumento
@Entity
@Table(name="tb_cadastro") //Da o nome da minha tabela
public class NinjaModel {

    @Id // informa que o atribuito abaixo será o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de como será gerado o id
    private long id;
    private String nome;
    private String email;
    private String aldeia;
    int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, String aldeia, int idade) {
        this.nome = nome;
        this.email = email;
        this.aldeia = aldeia;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
