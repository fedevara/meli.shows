package meli.shows.controllers.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import meli.shows.entities.dto.ButacaDTO;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class FuncionButacasResponse {

    private Long idShow;
    private String nombre;
    private String categoria;
    private int duracion;
    private LocalDateTime diaHorario;
    private List<ButacaDTO> butacas;

}
