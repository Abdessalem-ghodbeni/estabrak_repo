package com.biat.biat.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Agent")
public class Agent extends User  {

    @Column(name="cin")
    private long cin;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;




}
