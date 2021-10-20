package meli.shows.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Teatro")
@Getter
@Setter
public class Teatro {

    @Id
    @Column(name="idTeatro")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    @OneToMany(mappedBy = "teatro", cascade = CascadeType.ALL)
    private Set<Show> shows;

    @OneToMany(mappedBy = "teatro", cascade = CascadeType.ALL)
    private Set<Sala> salas;

}
