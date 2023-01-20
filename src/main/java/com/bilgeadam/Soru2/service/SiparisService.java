package com.bilgeadam.Soru2.service;

import com.bilgeadam.Soru2.Main;
import com.bilgeadam.Soru2.entity.Siparis;
import com.bilgeadam.Soru2.entity.SiparisKalemi;
import com.bilgeadam.Soru2.repository.SiparisDao;

import java.util.ArrayList;
import java.util.List;

public class SiparisService {
    static SiparisDao siparisDao = new SiparisDao();
    static Main m = new Main();
    public static void main(String[] args) {
        //save();
        //getAll(); // 2/A    native query ile deneme
        //getAllBymusteriId(); // 2/C
        //musteriIsimSiparisNo(); // 2/D
        //getAll2(); // 2/A   hibernate ile çözüm
    }
    public static void save(){
        siparisDao.save(m.s3);
    }
    public static void getAll(){
        siparisDao.getAll();
    }
    public static void getAllBymusteriId(){
        siparisDao.getAllBymusteriId(3);
    }
    public static void musteriIsimSiparisNo(){
        siparisDao.musteriIsimSiparisNo();
    }
    public static void getAll2(){
        List<Siparis> siparisList=new ArrayList<>();
        siparisList=siparisDao.getAll2();
        for(Siparis item : siparisList){
            System.out.println("sipariş id: "+item.getId()+" müşteri: "+item.getMusteri().getMusteriIsmi()+
                    " "+item.getMusteri().getMusteriSoyisim()+" id: "+item.getMusteri().getMusteriid());
            int siparisToplam=0;
            for (SiparisKalemi item2 : item.getSiparisKalemiList()){
                System.out.println("ürün: "+item2.getUrun().getUrunIsmi()+" fiyatı: "+item2.getUrun().getFiyat()+
                        " adet sayısı: "+item2.getUrunAdedi());
                siparisToplam=item2.getUrunAdedi()*item2.getUrun().getFiyat()+siparisToplam;

            }
            System.out.println("toplam fiyat: "+siparisToplam);
        }
    }
}
