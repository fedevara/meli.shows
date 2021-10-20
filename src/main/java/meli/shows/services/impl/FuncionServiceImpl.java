package meli.shows.services.impl;

import meli.shows.entities.Funcion;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.repository.FuncionRepository;
import meli.shows.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    FuncionRepository funcionRepository;

    @Override
    public FuncionDTO registrar(FuncionDTO funcion) {
        if(funcion != null){
            Funcion funcionOk = funcionRepository.save(FuncionAssembler.assemble(funcion));
            return FuncionAssembler.assemble(funcionOk);
        }
        return null;
    }

    @Override
    public List<FuncionDTO> getAll() {

        List<FuncionDTO> funcionResponse = new ArrayList<>();

        for (Funcion funcion : funcionRepository.findAll()) {
            funcionResponse.add(FuncionAssembler.assemble(funcion));
        }

        return funcionResponse;

    }

    @Override
    public Funcion modificar(Funcion funcion) {
        return null;
    }

    @Override
    public void borrar(Long id) {

    }

    @Override
    public Optional<Funcion> getById(Long id) {

        return funcionRepository.findById(id);

    }
}
