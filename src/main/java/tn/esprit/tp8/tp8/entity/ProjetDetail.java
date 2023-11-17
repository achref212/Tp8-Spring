package tn.esprit.tp8.tp8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String description;
    private  String technologie;
    private  Long cout;
    private Date datedebut;
    @OneToOne(mappedBy="projetDetail")
    @JsonIgnore
    private Projet projet;





}
