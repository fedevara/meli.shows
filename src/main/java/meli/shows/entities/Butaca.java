package meli.shows.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Butaca")
@Getter
@Setter
public class Butaca {

    @Id
    @Column(name = "idButaca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer fila;

    @NotNull
    private Integer posicion;

    @ManyToOne
    @JoinColumn(name = "idSeccionFK", referencedColumnName = "idSeccion")
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "idSalaFK", referencedColumnName = "idSala")
    private Sala sala;

}