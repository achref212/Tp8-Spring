package tn.esprit.tp8.tp8.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp8.tp8.entity.Equipe;
import tn.esprit.tp8.tp8.service.IEquipeService;

import java.util.List;

@Tag(name = "Gestion Equipe")

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    IEquipeService equipeDetailService;

    // http://localhost:8089/tp8/equipe/retriveve-all-equipes
    @Operation(description = "Récupérer toutes les Equipes de la base de données")
    @GetMapping("/retriveve-all-equipes")
    public List<Equipe> getEquipes(){
        List<Equipe> listEquipes = equipeDetailService.retrieveAllEquipes();
        return listEquipes;
    }

    // http://localhost:8089/tp8/equipe/retriveve-equipe/8
    @Operation(description = "Récupérer une Equipe avec ID de la base de données")
    @GetMapping("/retriveve-equipe/{equipe-id}")
    public Equipe retrieveequipe(@PathVariable("equipe-id") Long blId){
        return equipeDetailService.retieveEquipe(blId);
    }

    // http://localhost:8089/tp8/equipe/add-equipe
    @Operation(description = "Ajouter un equipe à la base de données")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe b){
        return equipeDetailService.addEquipe(b);
    }

    //http://localhost:8089/tp8/equipe/remove-equipe/8
    @Operation(description = "Supprimer un equipe de la base de données")
    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Long equipeId){
        equipeDetailService.retieveEquipe(equipeId);
    }

    // http://localhost:8089/tp8/equipe/modify-equipe
    @Operation(description = "Modifier une equipe de la base de données")
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe b){
        return equipeDetailService.modifyEquipe(b);
    }
    //http://localhost:8089/tp8/Projet/affecter-projet-a-equipe/1/1
    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void affecterProjetEquipe(@PathVariable("projet-id") Long proejtId,
                                     @PathVariable("equipe-id") Long proejtDetailsId) {
        equipeDetailService.assignProjetToEquipe(proejtId, proejtDetailsId);
    }
    // http://localhost:8089/tp8/projet/desaffecter-projet-de-equipe/1/1
    @PutMapping("/desaffecter-projet-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecterProjetdeEquipe(
            @PathVariable("projet-id") Long proejtId,
            @PathVariable("equipe-id") Long EquipeId) {
        equipeDetailService.desaffecterProjetFromEquipe(proejtId,EquipeId);
    }
}
