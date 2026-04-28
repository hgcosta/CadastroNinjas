package dev.hugocosta.CadastroNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }
    // Listar por ID
    public NinjaModel listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar novo Ninja
    public NinjaModel criarMinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Deletar ninja - Precisa ser um metodo void
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinjaId(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
