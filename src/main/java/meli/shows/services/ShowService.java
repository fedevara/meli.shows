package meli.shows.services;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.controllers.response.FuncionButacasResponse;
import meli.shows.entities.Show;
import meli.shows.entities.dto.ShowDTO;
import meli.shows.entities.exception.FuncionNotFoundException;
import meli.shows.entities.exception.ShowNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ShowService {

    List<ShowDTO> getAll();

    FuncionButacasResponse getShowInfo(Long idFuncion, Long idShow) throws FuncionNotFoundException, ShowNotFoundException;

    Optional<Show> getById(Long id);

    List<ShowDTO> getAdvancedAll(AdvanceSearchRequest request);
}