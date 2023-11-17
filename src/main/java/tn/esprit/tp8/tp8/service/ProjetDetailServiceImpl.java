package tn.esprit.tp8.tp8.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp8.tp8.entity.ProjetDetail;
import tn.esprit.tp8.tp8.repository.ProjetDetailRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetDetailServiceImpl implements IProjetDetailService {
    ProjetDetailRepository projetRepository;
    public List<ProjetDetail> retrieveAllProjetDetails(){
        return projetRepository.findAll();
    }
    public ProjetDetail retieveProjetDetail(long projetdId){
        return projetRepository.findById(projetdId).get();
    }
    public ProjetDetail addProjetDetail(ProjetDetail b){
        return projetRepository.save(b);
    }
    public void removeProjetDetail(long projetdId){
        projetRepository.deleteById(projetdId);
    }
    public ProjetDetail modifyProjetDetail(ProjetDetail projetd){
        return projetRepository.save(projetd);
    }
}
