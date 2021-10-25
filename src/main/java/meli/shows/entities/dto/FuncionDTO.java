package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class FuncionDTO {

    private Long id;
    private LocalDateTime diaHorario;
    private Long idShow;

}
