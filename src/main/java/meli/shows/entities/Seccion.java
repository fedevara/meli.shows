package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="Seccion")
@Getter
@Setter
public class Seccion {

    @Id
    @Column(name="idSeccion")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idShowFK", referencedColumnName = "idShow")
    private Show show;

    private BigDecimal precio;

    @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
    private Set<Butaca> butacas;

}
