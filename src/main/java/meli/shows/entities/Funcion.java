package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Funcion")
@Getter
@Setter
@Accessors(chain = true)
public class Funcion {

    @Id
    @Column(name = "idFuncion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime diaHorario;

    @ManyToOne
    @JoinColumn(name = "idShowFK", referencedColumnName = "idShow")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "idSalaFK", referencedColumnName = "idSala")
    private Sala sala;

}
