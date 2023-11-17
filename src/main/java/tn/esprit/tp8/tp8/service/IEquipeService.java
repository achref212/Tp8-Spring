package tn.esprit.tp8.tp8.service;

import tn.esprit.tp8.tp8.entity.Equipe;


import java.util.List;

public interface IEquipeService {

    public List<Equipe> retrieveAllEquipes();
    public Equipe retieveEquipe(long equipeId);
    public Equipe addEquipe(Equipe b);
    public void removeEquipe(long equipeId);
    public Equipe modifyEquipe(Equipe equipe);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public  void desaffecterProjetFromEquipe(Long projetId,Long equipeId);
}
