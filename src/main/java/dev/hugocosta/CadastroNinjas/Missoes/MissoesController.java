package dev.hugocosta.CadastroNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Criar missão
    @PostMapping("/adicionar")
    public String adicionarMissao(){
        return "Missao Adicionada";
    }

    // Listar Todas as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable long id){
        return missoesService.listarPorId(id);
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
