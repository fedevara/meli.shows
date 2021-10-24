package meli.shows.controllers.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ReservaRequest {

    @NotNull(message = "funcion is required")
    private Long funcion;
    @NotNull(message = "nombre is required")
    private String nombre;
    @NotNull(message = "documento is required")
    private String documento;
    @NotNull(message = "butaca is required")
    private Long butaca;
    @NotNull(message = "precio is required")
    private BigDecimal precio;

}
