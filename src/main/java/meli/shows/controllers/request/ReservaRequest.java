package meli.shows.controllers.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ReservaRequest {

    @NotNull(message="funcion is required")
    private Long funcion;

    private String nombre;

    private String documento;

    private Long butaca;

    private BigDecimal precio;

}
