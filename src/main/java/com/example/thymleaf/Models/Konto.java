package com.example.thymleaf.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Konto {

    @Id
    @GeneratedValue
    private Long Id;
    private int saldo;
    private int ranta;

    public Konto(int saldo, int ranta){
        this.saldo=saldo;
        this.ranta=ranta;
    }

}
