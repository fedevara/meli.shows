package meli.shows.services;

import meli.shows.entities.Funcion;
import meli.shows.entities.dto.FuncionDTO;

import java.util.List;
import java.util.Optional;

public interface FuncionService {

    List<FuncionDTO> getAll();

    Optional<Funcion> getById(Long id);

}