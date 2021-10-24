package meli.shows.controllers.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class AdvanceSearchRequest {

    private String nombre;
    private String categoria;
    private String fechaInicio;
    private String fechaFin;
    private String orden;
    private String direccion;
    private Double precioMinimo;
    private Double precioMaximo;

}
