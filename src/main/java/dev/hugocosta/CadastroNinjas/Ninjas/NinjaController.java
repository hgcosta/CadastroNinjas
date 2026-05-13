package dev.hugocosta.CadastroNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotação para informar que é um controller
@RequestMapping("/ninjas") // Anotação para rotas
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO novoNinja =  ninjaService.criarMinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso " + novoNinja.getNome());
    }

    // Listar os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjas);
    }
    // Procurar Ninja (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){

         NinjaDTO ninjaId = ninjaService.listarPorId(id) ;
         if(ninjaId != null){
             return ResponseEntity.ok(ninjaId);
         }else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Ninja ID: " + id + " não foi encontrado");
         }

    }
    // Alterar ninja (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinjaId(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + "não encontrado");
        }

    }
    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if(ninjaService.listarPorId(id) != null ){
            ninjaService.deletarNinjaId(id);
            return  ResponseEntity.ok("Ninja deletado com sucesso (ID)" + id);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de (ID) " +id + " Não foi encontrado");
    }


}
