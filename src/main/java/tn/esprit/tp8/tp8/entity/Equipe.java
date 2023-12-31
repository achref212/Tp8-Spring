package tn.esprit.tp8.tp8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEquipe;
    private  String nom;
    @Enumerated(EnumType.STRING)
    private Domaine domaine;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Projet> projets;

}
