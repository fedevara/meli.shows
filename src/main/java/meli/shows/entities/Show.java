package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Show")
@Getter
@Setter
public class Show {

    @Id
    @Column(name="idShow")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    private Integer duracion;

    @ManyToOne
    @JoinColumn(name="idTeatroFK", referencedColumnName = "idTeatro")
    private Teatro teatro;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private Set<Funcion> funciones;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private Set<Seccion> secciones;

}
