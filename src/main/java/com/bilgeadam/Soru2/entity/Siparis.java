package com.bilgeadam.Soru2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Siparis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Musteri musteri;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SiparisKalemi> siparisKalemiList;

    public Siparis() {
    }

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemiList) {
        this.musteri = musteri;
        this.siparisKalemiList = siparisKalemiList;
    }
}
