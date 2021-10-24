package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShowDTO {

    private Long id;
    private String nombre;
    private String categoria;
    private Integer duracion;
    private List<FuncionDTO> funciones;
    private List<SeccionDTO> secciones;

}
