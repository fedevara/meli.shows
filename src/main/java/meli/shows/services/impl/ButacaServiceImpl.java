package meli.shows.services.impl;

import meli.shows.entities.Butaca;
import meli.shows.entities.assembler.ButacaAssembler;
import meli.shows.entities.dto.ButacaDTO;
import meli.shows.repository.ButacaRepository;
import meli.shows.services.ButacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ButacaServiceImpl implements ButacaService {

    @Autowired
    ButacaRepository butacaRepository;

    @Override
    public List<ButacaDTO> getAll() {

        List<ButacaDTO> butacaResponse = new ArrayList<>();

        for (Butaca butaca : butacaRepository.findAll()) {
            butacaResponse.add(ButacaAssembler.assemble(butaca));
        }

        return butacaResponse;

    }

    @Override
    public Optional<Butaca> getById(Long id) {
        return butacaRepository.findById(id);
    }

    @Override
    public List<ButacaDTO> getButacasLibresFuncion(Long idFuncion) {
        List<ButacaDTO> butacaList = new ArrayList<>();
        for (Butaca butaca : butacaRepository.getButacasLibresFuncion(idFuncion)) {
            butacaList.add(ButacaAssembler.assemble(butaca));
        }
        return butacaList;
    }

}
