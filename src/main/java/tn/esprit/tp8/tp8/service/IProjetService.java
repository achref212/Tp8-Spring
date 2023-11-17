package tn.esprit.tp8.tp8.service;

import tn.esprit.tp8.tp8.entity.Projet;

import java.util.List;

public interface IProjetService {

    public List<Projet> retrieveAllProjets();
    public Projet retieveProjet(long blocId);
    public Projet addProjet(Projet b);
    public void removeProjet(long blocId);
    public Projet modifyProjet(Projet bloc);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId);

}
