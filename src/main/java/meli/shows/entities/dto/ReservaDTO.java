package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReservaDTO {

    private FuncionDTO funcion;

    private String nombre;

    private String documento;

    private ButacaDTO butaca;

    private BigDecimal precio;

}
