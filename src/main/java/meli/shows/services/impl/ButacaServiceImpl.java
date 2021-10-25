package meli.shows.services.impl;

import lombok.RequiredArgsConstructor;
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


    private ButacaRepository butacaRepository;

    @Autowired
    public ButacaServiceImpl(ButacaRepository butacaRepository) {
        this.butacaRepository = butacaRepository;
    }

    @Override
    public List<ButacaDTO> getAll() {

        List<ButacaDTO> butacaResponse = new ArrayList<>();

        for (Butaca butaca : butacaRepository.findAll()) {
            butacaResponse.add(ButacaAssembler.assemble(butaca));
        }

        return butacaResponse;

    }

    // TODO buscar una butaca, butaca no encontrada
    @Override
    public Optional<Butaca> getById(Long id) {
        return butacaRepository.findById(id);
    }

    // TODO buscar x butacas y que las devuelva bien, no devolver ninguna
    @Override
    public List<ButacaDTO> getButacasLibresFuncion(Long idFuncion) {
        List<ButacaDTO> butacaList = new ArrayList<>();
        for (Butaca butaca : butacaRepository.getButacasLibresFuncion(idFuncion)) {
            butacaList.add(ButacaAssembler.assemble(butaca));
        }
        return butacaList;
    }

}