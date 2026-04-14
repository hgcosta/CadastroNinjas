package dev.hugocosta.CadastroNinjas.Missoes;

import dev.hugocosta.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes") // Na classe Missao poderá ter vários Ninjas
    private List<NinjaModel> ninjas;

}
