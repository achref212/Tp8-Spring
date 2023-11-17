package tn.esprit.tp8.tp8.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp8.tp8.entity.Equipe;
import tn.esprit.tp8.tp8.entity.Projet;
import tn.esprit.tp8.tp8.entity.ProjetDetail;
import tn.esprit.tp8.tp8.repository.EquipeRepository;
import tn.esprit.tp8.tp8.repository.ProjetDetailRepository;
import tn.esprit.tp8.tp8.repository.ProjetRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    ProjetRepository projetRepository;
    ProjetDetailRepository projetDetailRepository;
    EquipeRepository equipeRepository;
    public List<Projet> retrieveAllProjets(){
        return projetRepository.findAll();
    }
    public Projet retieveProjet(long projetId){
        return projetRepository.findById(projetId).get();
    }
    public Projet addProjet(Projet b){
        return projetRepository.save(b);
    }
    public void removeProjet(long projetId){
        projetRepository.deleteById(projetId);
    }
    public Projet modifyProjet(Projet projet){
        return projetRepository.save(projet);
    }
    public Projet addProjetAndProjetDetailAndAssign(Projet projet){return projetRepository.save(projet);}
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }
}
