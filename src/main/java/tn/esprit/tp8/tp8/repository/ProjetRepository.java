package tn.esprit.tp8.tp8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp8.tp8.entity.Projet;

public interface ProjetRepository  extends JpaRepository<Projet, Long> {
}
