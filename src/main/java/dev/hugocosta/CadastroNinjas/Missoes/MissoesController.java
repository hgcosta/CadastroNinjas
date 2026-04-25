package dev.hugocosta.CadastroNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Criar missão
    @PostMapping("/adicionar")
    public String adicionarMissao(){
        return "Missao Adicionada";
    }

    // Listar Todas as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Listar missao";
    }

    @GetMapping("/listar/id")
    public String listarMissaoPorId(){
        return "Listar por id";
    }

    @PutMapping("/alterar")
    public String atualizarMissaoPorId(){
        return "Atualizar missao por id";
    }

    @DeleteMapping("deletear")
    public String deletarMissaoPorId(){
        return "Deletar missao por id";
    }
}
