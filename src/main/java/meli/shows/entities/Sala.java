package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Sala")
@Getter
@Setter
public class Sala {

    @Id
    @Column(name = "idSala")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTeatroFK", referencedColumnName = "idTeatro")
    private Teatro teatro;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private Set<Butaca> butacas;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private Set<Funcion> funciones;

}
