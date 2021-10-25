package meli.shows.entities.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class ButacaDTO {

    private Long id;
    private Integer fila;
    private Integer posicion;

}
