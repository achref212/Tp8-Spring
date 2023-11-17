package tn.esprit.tp8.tp8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idProjet;
    private  String sujet;
    @ManyToMany(mappedBy="projets", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Equipe> equipes;
    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private ProjetDetail projetDetail;
}
