package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReservaPK implements Serializable {

    private Long butaca;
    private Long funcion;

}