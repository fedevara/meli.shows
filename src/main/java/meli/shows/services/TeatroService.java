package meli.shows.services;

import meli.shows.entities.Teatro;
import meli.shows.entities.dto.TeatroDTO;

import java.util.List;
import java.util.Optional;

public interface TeatroService {

    List<TeatroDTO> getAll();

    Teatro modificar(Teatro teatro);

    void borrar(Long id);

    Optional<Teatro> getById(Long id);

}