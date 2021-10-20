package meli.shows.controllers.response;

import lombok.Getter;
import lombok.Setter;
import meli.shows.entities.dto.ButacaDTO;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FuncionButacasResponse {

    private Long idShow;

    private String nombre;

    private String categoria;

    private int duracion;

    private LocalDateTime diaHorario;

    private List<ButacaDTO> butacas;

}
