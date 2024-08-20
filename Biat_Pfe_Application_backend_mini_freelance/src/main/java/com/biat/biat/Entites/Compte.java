package com.biat.biat.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="Compte")
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCompte;

    @ManyToOne
    @JoinColumn(name = "code_banque", referencedColumnName = "codeBanque")
    private Banque banque;


}
