package meli.shows.repository;

import meli.shows.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(
            value = "SELECT R.* FROM RESERVA R WHERE R.ID_FUNCIONFK = :funcionId AND R.ID_BUTACAFK = :butacaId",
            nativeQuery = true)
    Optional<Reserva> selectByButacaAndFuncion(@Param("butacaId") long butacaId, @Param("funcionId") long funcionId);

}
