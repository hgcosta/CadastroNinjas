package dev.hugocosta.CadastroNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarMinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    // Deletar ninja - Precisa ser um metodo void
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinjaId(Long id, NinjaModel ninjaAtualizado){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        if(ninja.isPresent()){
            NinjaModel ninjaExistente = ninja.get();

            ninjaAtualizado.setId(id);

            if(ninjaAtualizado.getIdade() == null){
                ninjaAtualizado.setIdade(ninjaExistente.getIdade());
            }

            return ninjaRepository.save(ninjaAtualizado);
        }

        return null;
    }

}
