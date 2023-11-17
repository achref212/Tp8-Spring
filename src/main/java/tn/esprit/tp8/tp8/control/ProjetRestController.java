package tn.esprit.tp8.tp8.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp8.tp8.entity.Projet;
import tn.esprit.tp8.tp8.service.IProjetService;

import java.util.List;

@Tag(name = "Gestion Projet")

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {
    IProjetService projetDetailService;

    // http://localhost:8089/tp8/projet/retriveve-all-projets
    @Operation(description = "Récupérer toutes les Projets de la base de données")
    @GetMapping("/retriveve-all-projets")
    public List<Projet> getProjets(){
        List<Projet> listProjets = projetDetailService.retrieveAllProjets();
        return listProjets;
    }

    // http://localhost:8089/tp8/projet/retriveve-projet/8
    @Operation(description = "Récupérer une Projet avec ID de la base de données")
    @GetMapping("/retriveve-projet/{projet-id}")
    public Projet retrieveprojet(@PathVariable("projet-id") Long blId){
        return projetDetailService.retieveProjet(blId);
    }

    // http://localhost:8089/tp8/projet/add-projet
    @Operation(description = "Ajouter un projet à la base de données")
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet b){
        return projetDetailService.addProjet(b);
    }

    //http://localhost:8089/tp8/projet/remove-projet/8
    @Operation(description = "Supprimer un projet de la base de données")
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long projetId){
        projetDetailService.retieveProjet(projetId);
    }

    // http://localhost:8089/tp8/projet/modify-projet
    @Operation(description = "Modifier une projet de la base de données")
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet b){
        return projetDetailService.modifyProjet(b);
    }
    // http://localhost:8089/tp8/projet/modify-projet
    @Operation(description = "add une projetdetail dans projet de la base de données")
    @PostMapping("/add-projet-projetdetail")
    public Projet addProjetAndProjetDetailAndAssign(@RequestBody Projet b){
        return projetDetailService.addProjetAndProjetDetailAndAssign(b);
    }
    //#http://localhost:8089/tp8/projet/affecter-projet-a-projet-details/1/1
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecgterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                             @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetDetailService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }
    //http://localhost:8089/tp8/projet/creer-projet-et-affecter-projet-detail-a-projet/1           cas4
    @PutMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projet-details-id}")
    public void ajouterProjetetAffecterProjetAProjetDetail(@RequestBody Projet p,
                                                           @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetDetailService.addProjetAndAssignProjetToProjetDetail(p, proejtDetailsId);
    }
    //http://localhost:8089/tp8/projet/desaffecter-projet-detail/1   cas5
    @PutMapping("/desaffecter-projet-detail/{projet-details-id}")
    public void ajouterProjetetAffecterProjetAProjetDetail(
            @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetDetailService.DesaffecterProjetDetailFromProjet(proejtDetailsId);
    }
}
