package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Reserva")
@IdClass(ReservaPK.class)
@Getter
@Setter
public class Reserva {

    @Id
    @ManyToOne
    @JoinColumn(name = "idButacaFK", referencedColumnName = "idButaca")
    private Butaca butaca;

    @Id
    @ManyToOne
    @JoinColumn(name = "idFuncionFK", referencedColumnName = "idFuncion")
    private Funcion funcion;

    private String nombre;

    private String documento;

    private BigDecimal precio;

}
