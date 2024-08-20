package com.biat.biat.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Caissier")
public class Caissier extends User  {
    @Column(name = "adresse")
    private String adresse;
}
