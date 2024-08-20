package com.biat.biat.Repository;

import com.biat.biat.Entites.Compte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByNumeroCompte(String numeroCompte);
}
