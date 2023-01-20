package com.bilgeadam.Soru2;

import com.bilgeadam.Soru2.entity.Musteri;
import com.bilgeadam.Soru2.entity.Siparis;
import com.bilgeadam.Soru2.entity.SiparisKalemi;
import com.bilgeadam.Soru2.entity.Urun;

import java.util.Arrays;

public class Main {
    public Musteri m1 = new Musteri("Ali","Kaya");
    public Musteri m2 = new Musteri("Veli","Ozkan");
    public Musteri m3 = new Musteri("bertan","mortas");


    public Urun u1 = new Urun("IPhone 11",17000);
    public Urun u2 = new Urun("Samsung s21",18000);
    public Urun u3 = new Urun("LG LED TV",8500);
    public Urun u4 = new Urun("Arcelik Süpürge",2500);

    public SiparisKalemi sk1 = new SiparisKalemi(u1,1);
    public SiparisKalemi sk2 = new SiparisKalemi(u2,2);
    public Siparis s1 = new Siparis(m1, Arrays.asList(sk1,sk2));
    public SiparisKalemi sk3 = new SiparisKalemi(u3,2);
    public SiparisKalemi sk4 = new SiparisKalemi(u4,1);
    public Siparis s2 = new Siparis(m2, Arrays.asList(sk3,sk4));
    public Siparis s3 = new Siparis(m3, Arrays.asList(sk1,sk3,sk4));
}
