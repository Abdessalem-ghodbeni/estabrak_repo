package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Banque;
import com.biat.biat.Entites.Cheque;
import com.biat.biat.Repository.BanqueRepository;
import com.biat.biat.Repository.ChequeRepository;
import com.biat.biat.Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ChequeService {
    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private BanqueRepository banqueRepository;

    public Cheque createCheque(Cheque cheque) {
        // Check if Banque already exists
        Banque existingBanque = banqueRepository.findById(cheque.getBanque().getCodeBanque()).orElse(null);
        if (existingBanque != null) {
            cheque.setBanque(existingBanque);
        } else {
            Banque savedBanque = banqueRepository.save(cheque.getBanque());
            cheque.setBanque(savedBanque);
        }

        // Check if Compte already exists
   //     Compte existingCompte = compteRepository.findByNumeroCompte(cheque.getCompte().getNumeroCompte());
     //   if (existingCompte != null) {
       //     cheque.setCompte(existingCompte);
        //} else {
          //  Compte savedCompte = compteRepository.save(cheque.getCompte());
            //cheque.setCompte(savedCompte);
        //}

        return chequeRepository.save(cheque);
    }

    public Cheque getCheque(String numero) {
        return chequeRepository.findById(numero).orElse(null);
    }

    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    public Cheque updateCheque(String numero, Cheque cheque) {
        Cheque existingCheque = chequeRepository.findById(numero).orElse(null);
        if (existingCheque != null) {
            existingCheque.setDateCreation(cheque.getDateCreation());
            existingCheque.setDateEmission(cheque.getDateEmission());
            existingCheque.setDateEntreeCaisse(cheque.getDateEntreeCaisse());
            existingCheque.setDateValeur(cheque.getDateValeur());
            existingCheque.setMontant(cheque.getMontant());
            existingCheque.setMotif(cheque.getMotif());
            existingCheque.setBeneficiaire(cheque.getBeneficiaire());
            existingCheque.setAnnuler(false);

            // Update the related Compte if necessary
           // if (cheque.getCompte() != null) {
             //   Compte existingCompte = compteRepository.findById(cheque.getCompte().getId()).orElse(null);
               // if (existingCompte == null) {
                 //   existingCompte = compteRepository.save(cheque.getCompte());
                //}
                //existingCheque.setCompte(existingCompte);
            //}

            return chequeRepository.save(existingCheque);
        }
        return null;
    }

    public void deleteCheque(String numero) {
        chequeRepository.deleteById(numero);
    }

    public List<Cheque> getNonEmisCheques() {
        return chequeRepository.findByDateEmissionIsNull();
    }

    public List<Cheque> getEmisCheques() {
        return chequeRepository.findByDateEmissionIsNotNull();
    }

    public List<Cheque> findChequesByNumero(String numero) {
        return chequeRepository.findByNumero(numero);
    }

    public List<Cheque> findChequesByBeneficiaire(String beneficiaire) {
        return chequeRepository.findByBeneficiaireContaining(beneficiaire);
    }

    public List<Cheque> findChequesByMotif(String motif) {
        return chequeRepository.findByMotifContaining(motif);
    }

    public List<Cheque> findChequesByDateCreationBetween(Date startDate, Date endDate) {
        return chequeRepository.findByDateCreationBetween(startDate, endDate);
    }
}