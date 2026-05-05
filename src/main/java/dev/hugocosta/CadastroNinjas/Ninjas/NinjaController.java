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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarMinja(ninja);
    }
    // Listar os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }
    // Procurar Ninja (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id) ;
    }
    // Alterar ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinjaId(id, ninjaAtualizado);
    }
    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaId(id);
    }


}
