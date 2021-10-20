package meli.shows.services;

import meli.shows.entities.Reserva;
import meli.shows.entities.dto.ReservaDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaDTO registrar(ReservaDTO reserva);

    List<ReservaDTO> getAll();

    Reserva modificar(Reserva teatro);

    void borrar(Long id);

    Optional<Reserva> getById(Long id);

}