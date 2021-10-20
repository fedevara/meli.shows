package meli.shows.services;

import meli.shows.entities.Teatro;
import meli.shows.entities.dto.TeatroDTO;

import java.util.List;
import java.util.Optional;

public interface TeatroService {

    List<TeatroDTO> getAll();

    Optional<Teatro> getById(Long id);

}