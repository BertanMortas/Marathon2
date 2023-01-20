package com.bilgeadam.Soru2.entity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class SiparisKalemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sipariskalemiid;
    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;
    private int urunAdedi;

    public SiparisKalemi() {
    }

    public SiparisKalemi(Urun urun, int urunAdedi) {
        this.urun = urun;
        this.urunAdedi = urunAdedi;
    }
}
