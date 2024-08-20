package com.biat.biat.Repository;

import com.biat.biat.Entites.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface ChequeRepository extends JpaRepository<Cheque, String> {

    @Query("SELECT COUNT(c) FROM Cheque c WHERE YEAR(c.dateCreation) = ?1")
    long countByYear(int year);

    List<Cheque> findByDateEmissionIsNull();
    List<Cheque> findByDateEmissionIsNotNull();
    List<Cheque> findByDateCreationBetween(Date startDate, Date endDate);
    List<Cheque> findByNumero(String numero);
    List<Cheque> findByBeneficiaireContaining(String beneficiaire);
    List<Cheque> findByMotifContaining(String motif);
}

