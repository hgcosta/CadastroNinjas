package dev.hugocosta.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotação para informar que é um controller
@RequestMapping("/ninjas") // Anotação para rotas
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    // Listar os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }
    // Procurar Ninja (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id) ;
    }
    // Alterar ninja (UPDATE)
    @PutMapping("/alterarId")
    public String alterarNinjaPorId(){
        return "Alterar ninja por Id";
    }
    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Deletar ninja por id";
    }
}
