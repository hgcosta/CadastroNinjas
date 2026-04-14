package dev.hugocosta.CadastroNinjas.Ninjas;

// É preciso transofrmar a classe model em entidades

import dev.hugocosta.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA = Java Persistence API
//@Entity transforma toda a classe em uma entidade do banco de dados falando a table com a coluna de cada argumento
@Entity
@Table(name="tb_cadastro") //Da o nome da minha tabela
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
