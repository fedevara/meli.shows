package meli.shows.entities.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class FuncionDTO {

    private Long id;
    private LocalDateTime diaHorario;
    private Long idShow;

}
