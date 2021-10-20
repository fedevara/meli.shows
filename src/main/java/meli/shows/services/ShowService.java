package meli.shows.services;

import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Show;
import meli.shows.entities.dto.ShowDTO;

import java.util.List;
import java.util.Optional;

public interface ShowService {

    List<ShowDTO> getAll();

    FuncionButacasResponse getShowInfo(Long idFuncion, Long idShow);

    Optional<Show> getById(Long id);

}