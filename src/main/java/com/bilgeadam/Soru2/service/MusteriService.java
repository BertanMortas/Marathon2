package com.bilgeadam.Soru2.service;

import com.bilgeadam.Soru2.entity.Musteri;
import com.bilgeadam.Soru2.entity.Siparis;
import com.bilgeadam.Soru2.entity.SiparisKalemi;
import com.bilgeadam.Soru2.repository.MusteriDao;

import java.util.ArrayList;
import java.util.List;

public class MusteriService {
    static MusteriDao musteriDao = new MusteriDao();
    public static void main(String[] args) {
        getAll(); //2/B
    }
    public static void getAll(){
        List<Musteri> musteriList = new ArrayList<>();
        musteriList = musteriDao.getAll();
        for (Musteri item : musteriList){
            System.out.println("müsteri id: "+item.getMusteriid()+
                    " müsteri ad: "+item.getMusteriIsmi()+
                    " müsteri soyad: "+item.getMusteriSoyisim()+
                    " sipariş id: "+item.getSiparis().getId());
            for (SiparisKalemi item2 : item.getSiparis().getSiparisKalemiList()){
                System.out.println("ürün: "+item2.getUrun().getUrunIsmi()+
                             " fiyat: "+ item2.getUrun().getFiyat()+
                             " adet: "+ item2.getUrunAdedi());
            }
        }
    }
}
