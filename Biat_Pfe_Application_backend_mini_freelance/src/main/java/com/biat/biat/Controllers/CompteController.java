package com.biat.biat.Controllers;

import com.biat.biat.Entites.Compte;
import com.biat.biat.Services.ServiceImpl.CompteService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;


    // http://localhost:8089/exam/comptes/retrieve-all-comptes
    @GetMapping("/retrieve-all-comptes")
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }


    // http://localhost:8089/exam/comptes/retrieve-comptes/1
    @GetMapping("/retrieve-comptes/{comptes-id}")
    public Compte getCompteById(@PathVariable("comptes-id") Long id) {
        return compteService.getCompteById(id);
    }

    // http://localhost:8089/exam/comptes/add-comptes
    @PostMapping("/add-comptes")
    public Compte createCompte(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    // http://localhost:8089/exam/comptes/modify-comptes/2
    @PutMapping("/modify-comptes/{comptes-id}")
    public Compte updateCompte(@PathVariable("comptes-id") Long id, @RequestBody Compte compte) {
        Compte existingCompte = compteService.getCompteById(id);
        if (existingCompte != null) {
            existingCompte.setNumeroCompte(compte.getNumeroCompte());
            existingCompte.setBanque(compte.getBanque());
            return compteService.saveCompte(existingCompte);
        }
        return null;
    }

    // http://localhost:8089/exam/comptes/remove-comptes/2
    @DeleteMapping("/remove-comptes/{comptes-id}")
    public void deleteCompte(@PathVariable("comptes-id") Long id) {
        compteService.deleteCompte(id);
    }

}

