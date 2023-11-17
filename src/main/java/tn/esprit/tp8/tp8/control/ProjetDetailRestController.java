package tn.esprit.tp8.tp8.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp8.tp8.entity.ProjetDetail;
import tn.esprit.tp8.tp8.service.IProjetDetailService;


import java.util.List;

@Tag(name = "Gestion ProjetDetail")

@RestController
@AllArgsConstructor
@RequestMapping("/projetdetail")
public class ProjetDetailRestController {
    IProjetDetailService projetDetailService;

    // http://localhost:8089/tp8/projetdetail/retriveve-all-projetdetails
    @Operation(description = "Récupérer toutes les ProjetDetails de la base de données")
    @GetMapping("/retriveve-all-projetdetails")
    public List<ProjetDetail> getProjetDetails(){
        List<ProjetDetail> listProjetDetails = projetDetailService.retrieveAllProjetDetails();
        return listProjetDetails;
    }

    // http://localhost:8089/tp8/projetdetail/retriveve-projetdetail/8
    @Operation(description = "Récupérer une ProjetDetail avec ID de la base de données")
    @GetMapping("/retriveve-projetdetail/{projetdetail-id}")
    public ProjetDetail retrieveprojetdetail(@PathVariable("projetdetail-id") Long blId){
        return projetDetailService.retieveProjetDetail(blId);
    }

    // http://localhost:8089/tp8/projetdetail/add-projetdetail
    @Operation(description = "Ajouter un projetdetail à la base de données")
    @PostMapping("/add-projetdetail")
    public ProjetDetail addprojetdetail(@RequestBody ProjetDetail b){
        return projetDetailService.addProjetDetail(b);
    }

    //http://localhost:8089/tp8/projetdetail/remove-projetdetail/8
    @Operation(description = "Supprimer un projetdetail de la base de données")
    @DeleteMapping("/remove-projetdetail/{projetdetail-id}")
    public void removeprojetdetail(@PathVariable("projetdetail-id") Long projetdetailId){
        projetDetailService.retieveProjetDetail(projetdetailId);
    }

    // http://localhost:8089/tp8/projetdetail/modify-projetdetail
    @Operation(description = "Modifier une projetdetail de la base de données")
    @PutMapping("/modify-projetdetail")
    public ProjetDetail modifyprojetdetail(@RequestBody ProjetDetail b){
        return projetDetailService.modifyProjetDetail(b);
    }
}
