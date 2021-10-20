package meli.shows.services;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;

import java.util.List;
import java.util.Optional;

public interface ButacaService {

    List<ButacaDTO> getAll();

    Optional<Butaca> getById(Long id);

    List<ButacaDTO> getButacasLibresFuncion(Long idFuncion);
}