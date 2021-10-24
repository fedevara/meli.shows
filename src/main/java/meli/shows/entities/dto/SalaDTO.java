package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class SalaDTO {

    private Long id;
    private List<ButacaDTO> butacas;
    private List<FuncionDTO> funciones;

}
