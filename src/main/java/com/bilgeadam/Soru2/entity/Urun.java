package com.bilgeadam.Soru2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor   hocam bunları biliyorum ama ben constructor oluşturup görerek daha rahat yapıyorum
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer urunid;
    private String urunIsmi;
    private int fiyat;

    public Urun() {
    }

    public Urun(String urunIsmi, int fiyat) {
        this.urunIsmi = urunIsmi;
        this.fiyat = fiyat;
    }
}
