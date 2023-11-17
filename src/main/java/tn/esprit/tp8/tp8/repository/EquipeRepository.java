package tn.esprit.tp8.tp8.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp8.tp8.entity.Domaine;
import tn.esprit.tp8.tp8.entity.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    List<Equipe> findAllByDomaine(Domaine tc);
}
