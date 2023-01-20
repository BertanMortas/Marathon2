package com.bilgeadam.Soru2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer musteriid;
    private String musteriIsmi;
    private String musteriSoyisim;
    @OneToOne(mappedBy = "musteri")
    private Siparis siparis;

    public Musteri() {
    }

    public Musteri(String musteriIsmi, String musteriSoyisim) {
        this.musteriIsmi = musteriIsmi;
        this.musteriSoyisim = musteriSoyisim;
    }
}
