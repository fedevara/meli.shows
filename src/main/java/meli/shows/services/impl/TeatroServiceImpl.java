package meli.shows.services.impl;

import meli.shows.entities.Teatro;
import meli.shows.entities.assembler.TeatroAssembler;
import meli.shows.entities.dto.TeatroDTO;
import meli.shows.repository.TeatroRepository;
import meli.shows.services.TeatroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeatroServiceImpl implements TeatroService {

    @Autowired
    TeatroRepository teatroRepository;

    @Override
    public List<TeatroDTO> getAll() {

        List<TeatroDTO> teatrosResponse = new ArrayList<>();

        for (Teatro teatro : teatroRepository.findAll()) {
            teatrosResponse.add(TeatroAssembler.assemble(teatro));
        }

        return teatrosResponse;

    }

    @Override
    public Teatro modificar(Teatro teatro) {
        return null;
    }

    @Override
    public void borrar(Long id) {

    }

    @Override
    public Optional<Teatro> getById(Long id) {
        return Optional.empty();
    }
}
