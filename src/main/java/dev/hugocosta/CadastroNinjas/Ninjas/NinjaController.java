package dev.hugocosta.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController // Anotação para informar que é um controller
@RequestMapping("/ninjas") // Anotação para rotas
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    // Listar os ninjas (READ)
    @GetMapping("/listar")
    public String monstrarTodosOsNinjas(){
        return "Mostrar todos os ninjas";
    }
    // Procurar Ninja (READ)
    @GetMapping("/listarId")
    public String mostrarTodosNinjaPorId(){
        return "Mostrar todos os ninjas por id";
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
