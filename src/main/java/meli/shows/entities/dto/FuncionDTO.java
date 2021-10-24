package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionDTO {

    private Long id;
    private LocalDateTime diaHorario;
    private Long idShow;

}
