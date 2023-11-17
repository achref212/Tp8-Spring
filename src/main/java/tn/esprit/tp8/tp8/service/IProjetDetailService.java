package tn.esprit.tp8.tp8.service;

import tn.esprit.tp8.tp8.entity.ProjetDetail;


import java.util.List;

public interface IProjetDetailService {

    public List<ProjetDetail> retrieveAllProjetDetails();
    public ProjetDetail retieveProjetDetail(long projetdId);
    public ProjetDetail addProjetDetail(ProjetDetail b);
    public void removeProjetDetail(long projetdId);
    public ProjetDetail modifyProjetDetail(ProjetDetail projetd);
}
