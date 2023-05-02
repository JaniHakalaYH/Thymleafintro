package com.example.thymleaf.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Kpi {

    @Id
    @GeneratedValue
    private Long Id;
    private int kreditvardighet;

    public Kpi(int cred){
        this.kreditvardighet=cred;
    }

}
