package com.biat.biat.Entites;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Cheque {

    @Id
    @GeneratedValue(generator = "custom-cheque-id-generator")
    @GenericGenerator(
            name = "custom-cheque-id-generator",
            strategy = "com.biat.biat.Entites.chequeIdGenerator",
            parameters = {
                    @Parameter(name = "prefix", value = "2024"), // Use the current year or dynamically determine
                    @Parameter(name = "number_format", value = "%06d")
            }
    )
    private String numero; // Primary key
    private double montant;
    private String beneficiaire;
    private String motif;
    private Date dateCreation;
    private Date dateValeur;
    private Date dateEntreeCaisse;
    private Date dateEmission;
    private String type;
    private boolean annuler = false;

    @ManyToOne
    @JoinColumn(name = "codeBanque")
    private Banque banque;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


}
