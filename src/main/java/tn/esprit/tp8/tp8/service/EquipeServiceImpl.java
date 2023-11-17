package tn.esprit.tp8.tp8.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp8.tp8.entity.Equipe;
import tn.esprit.tp8.tp8.entity.Projet;
import tn.esprit.tp8.tp8.repository.EquipeRepository;
import tn.esprit.tp8.tp8.repository.ProjetRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
    EquipeRepository equipeRepository;
    ProjetRepository projetRepository;
    public List<Equipe> retrieveAllEquipes(){
        return equipeRepository.findAll();
    }
    public Equipe retieveEquipe(long EquipeId){
        return equipeRepository.findById(EquipeId).get();
    }
    public Equipe addEquipe(Equipe b){
        return equipeRepository.save(b);
    }
    public void removeEquipe(long EquipeId){
        equipeRepository.deleteById(EquipeId);
    }
    public Equipe modifyEquipe(Equipe Equipe){
        return equipeRepository.save(Equipe);
    }

    public void assignProjetToEquipe(Long projetId,Long equipeId){
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe =equipeRepository.findById(equipeId).get();
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }
    public  void desaffecterProjetFromEquipe(Long projetId,Long equipeId){
        Projet projet =projetRepository.findById(projetId).get();
        Equipe equipe =  equipeRepository.findById(equipeId).get();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }

}
