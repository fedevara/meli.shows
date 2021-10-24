package meli.shows.repository;

import meli.shows.controllers.request.AdvanceSearchRequest;
import meli.shows.entities.Show;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowCustomRepository {

    List<Show> findAdvancedAll(AdvanceSearchRequest request);

}