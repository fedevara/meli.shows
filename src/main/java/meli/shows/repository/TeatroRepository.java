package meli.shows.repository;

import meli.shows.entities.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepository extends JpaRepository<Teatro, Long> {
}
