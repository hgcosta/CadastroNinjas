package dev.hugocosta.CadastroNinjas.Ninjas;

// É preciso transofrmar a classe model em entidades

import dev.hugocosta.CadastroNinjas.Missoes.MissoesModel;
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
    private int idade;
    // Na classe ninja terá apenas uma missão
    @ManyToOne
    @JoinColumn(name="missoes_id") // Foreing Key ou Chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel( String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
