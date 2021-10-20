package meli.shows.services;

import meli.shows.entities.Butaca;
import meli.shows.entities.dto.ButacaDTO;

import java.util.List;
import java.util.Optional;

public interface ButacaService {

    ButacaDTO registrar(ButacaDTO butaca);

    List<ButacaDTO> getAll();

    Butaca modificar(Butaca butaca);

    void borrar(Long id);

    Optional<Butaca> getById(Long id);

    List<ButacaDTO> getButacasLibresFuncion(Long idFuncion);
}