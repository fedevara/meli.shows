package meli.shows.services;

import meli.shows.entities.Funcion;
import meli.shows.entities.dto.FuncionDTO;

import java.util.List;
import java.util.Optional;

public interface FuncionService {

    FuncionDTO registrar(FuncionDTO funcion);

    List<FuncionDTO> getAll();

    Funcion modificar(Funcion funcion);

    void borrar(Long id);

    Optional<Funcion> getById(Long id);

}