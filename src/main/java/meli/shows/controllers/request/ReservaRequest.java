package meli.shows.controllers.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReservaRequest {

    private Long funcion;

    private String nombre;

    private String documento;

    private Long butaca;

    private BigDecimal precio;

}
