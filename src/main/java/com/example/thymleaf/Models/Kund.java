package com.example.thymleaf.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Kund {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String ssn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn               //FK-kolumn kommer, i default-fallet, att heta kpi_id
    //@JoinColumn(name="myFK", referencedColumnName="kreditvardighet")
    private Kpi kpi;

    public Kund(String name, String ssn, Kpi kpi){
        this.name=name;
        this.ssn=ssn;
        this.kpi = kpi;
    }

    //Nedanstående hör till N-1-filmen
    @ManyToOne
    @JoinColumn
    @JsonIgnore                               //Denna rad hör till 1-N-filmen
    private Kategori kategori;

    public Kund(String name, String ssn, Kpi kpi, Kategori kategori){
        this.name=name;
        this.ssn=ssn;
        this.kpi = kpi;
        this.kategori = kategori;
    }

    //Nedanstående hör till N-M-filmen
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Konto> konto = new ArrayList<>();

    public void addKonto(Konto k){
        konto.add(k);
    }

}
