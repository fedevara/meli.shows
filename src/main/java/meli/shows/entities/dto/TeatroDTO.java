package meli.shows.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeatroDTO {

    private Long id;

    private String nombre;

    private List<ShowDTO> shows;

    private List<SalaDTO> salas;

}
