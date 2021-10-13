package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;
import meli.shows.entities.Butaca;

import java.math.BigDecimal;

@Getter
@Setter
public class ReservaDTO {

    //PK COMBINADA ENTRE BUTACA Y FUNCION

    private Long id;

    private String nombre;

    private String documento;

    private ButacaDTO butaca;

    private BigDecimal precio;

}
