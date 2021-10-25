package meli.shows.entities.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class ReservaDTO {

    private FuncionDTO funcion;
    private String nombre;
    private String documento;
    private ButacaDTO butaca;
    private BigDecimal precio;

}
