package meli.shows.repository;

import meli.shows.entities.Butaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButacaRepository extends JpaRepository<Butaca, Long> {

    @Query(
            value = "SELECT B.* FROM BUTACA B INNER JOIN FUNCION F ON F.ID_SALAFK = B.ID_SALAFK WHERE F.ID_FUNCION = :idFuncion " +
                    "AND B.ID_BUTACA NOT IN (SELECT R.ID_BUTACAFK FROM RESERVA R WHERE R.ID_FUNCIONFK = F.ID_FUNCION);",
            nativeQuery = true)
    List<Butaca> getButacasLibresFuncion(@Param("idFuncion") Long idFuncion);

}
