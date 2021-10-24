package meli.shows.services;

import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Show;
import meli.shows.entities.dto.ShowDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ShowService {

    List<ShowDTO> getAll();

    FuncionButacasResponse getShowInfo(Long idFuncion, Long idShow);

    Optional<Show> getById(Long id);

    List<ShowDTO> getAdvancedAll(String nombre, String categoria, String fechaInicio, String fechaFin, String orden, String direccion, String precioMinimo, String precioMaximo);
}