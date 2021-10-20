package meli.shows.services;

import meli.shows.entities.Reserva;
import meli.shows.entities.dto.ReservaDTO;
import meli.shows.entities.exception.ReservaAlreadyExistException;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaDTO registrar(ReservaDTO reserva) throws ReservaAlreadyExistException;

    List<ReservaDTO> getAll();

    Optional<Reserva> getById(Long id);

}