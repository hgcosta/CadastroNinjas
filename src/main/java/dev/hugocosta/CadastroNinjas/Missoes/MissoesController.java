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
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
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

    @DeleteMapping("deletar/{id}")
    public void deletarMissaoPorId(@PathVariable long id){
        missoesService.deletarMissaoPorId(id);

    }
}
