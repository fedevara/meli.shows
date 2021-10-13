package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Reserva")
@Getter
@Setter
public class Reserva {

    //PK COMBINADA ENTRE BUTACA Y FUNCION

    @Id
    @Column(name="idReserva")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String documento;

    @OneToOne
    @JoinColumn(name="idButacaFK", referencedColumnName = "idButaca")
    private Butaca butaca;

    private BigDecimal precio;

}
