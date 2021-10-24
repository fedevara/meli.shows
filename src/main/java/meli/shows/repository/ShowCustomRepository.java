package meli.shows.repository;

import meli.shows.entities.Show;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShowCustomRepository {

    List<Show> findAdvancedAll(String nombre, String categoria, String fechaInicio, String fechaFin, String orden, String direccion, String precioMinimo, String precioMaximo);

}