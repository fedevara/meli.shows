package meli.shows.services.impl;

import meli.shows.entities.Funcion;
import meli.shows.entities.assembler.FuncionAssembler;
import meli.shows.entities.dto.FuncionDTO;
import meli.shows.repository.ButacaRepository;
import meli.shows.repository.FuncionRepository;
import meli.shows.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionServiceImpl implements FuncionService {

    private final FuncionRepository funcionRepository;

    @Autowired
    public FuncionServiceImpl(FuncionRepository funcionRepository) {
        this.funcionRepository = funcionRepository;
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
    public Optional<Funcion> getById(Long id) {

        return funcionRepository.findById(id);

    }
}
