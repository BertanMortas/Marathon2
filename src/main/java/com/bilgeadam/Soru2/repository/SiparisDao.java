package com.bilgeadam.Soru2.repository;

import com.bilgeadam.Soru2.entity.Musteri;
import com.bilgeadam.Soru2.entity.Siparis;

import com.bilgeadam.Soru2.utils.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import java.util.List;

public class SiparisDao implements ICrud<Siparis> {
    @Override
    public void save(Siparis siparis) {
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            session.close();
            System.out.println("kayıt başarılı");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("Kayıt başarısız!!!");
        }

    }

    @Override
    public void getAll() { // duplicate error ü aldım o yüzden idlerim başka şekilde adlandırdım
        // 2/A
        try {
            String sql2="select m.musteriid from hibernate_marathon2.Siparis as s\n" +
                    "inner join hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                    "inner join hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                    "inner join hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                    "inner join hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                    "group by musteriid ";
            Session session = Hibernate.getSessionFactory().openSession();
            String sql= "select sk.sipariskalemiid ,m.musteriIsmi,m.musteriSoyisim,m.musteriid ,u.urunIsmi,u.fiyat,sk.urunAdedi from hibernate_marathon2.Siparis as s\n" +
                    "inner join hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                    "inner join hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                    "inner join hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                    "inner join hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                    "where musteriid =:aa";
            String sql3DenemeSorgusu="SELECT s.id as \"Sipariş ID\", m.musteriIsmi as \"Müşteri\", m.musteriid as \"Musteri ID\", \n" +
                    "        u.urunIsmi as \"Ürün\", u.fiyat as \"Fiyat\", sk.urunAdedi as \"Adet Sayısı\", \n" +
                    "        SUM(u.fiyat * sk.urunAdedi) as \"Sipariş Toplam\", t.genelToplam as \"Genel Toplam\"\n" +
                    "FROM hibernate_marathon2.Siparis as s\n" +
                    "INNER JOIN hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                    "INNER JOIN hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                    "INNER JOIN hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                    "INNER JOIN hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                    "INNER JOIN (SELECT m.musteriid as \"musteriID\", SUM(u.fiyat * sk.urunAdedi) as \"genelToplam\"\n" +
                    "            FROM hibernate_marathon2.Siparis as s\n" +
                    "            INNER JOIN hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                    "INNER JOIN hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                    "INNER JOIN hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                    "INNER JOIN hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                    "            GROUP BY m.musteriid) as t ON t.musteriID = m.musteriid\n" +
                    "GROUP BY s.id, m.musteriIsmi, m.musteriid, u.urunIsmi, u.fiyat, sk.urunAdedi;";
            Query query2 = session.createNativeQuery(sql2);
            List<Integer> musteriList = query2.getResultList();
            int i =1;
            for (i=1; i<=musteriList.size();i++){
                Query query = session.createNativeQuery(sql);
                query.setParameter("aa",i);
                List<Object[]> siparisList = query.getResultList();
                for (Object[] item : siparisList) {
                    System.out.println("===================");
                    System.out.println(
                            "siapris id: " + item[0] +
                                    " müsteri ismi " + item[1] +
                                    " musteri soyismi: " + item[2] +
                                    " musteri id: " + item[3] +
                                    " urun adı: " + item[4] +
                                    " urun fiyatı : " + item[5] +
                                    " urun adedi: " + item[6] +
                                    " sipariş fiyatı: " +
                                    (Integer.valueOf((Integer) item[5])*Integer.valueOf((Integer) item[6]))
                    );
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("sorgu başarısız!!!");
        }
    }
    public void getAllBymusteriId(int musteriId){ // duplicate error ü aldım o yüzden idlerim başka şekilde adlandırdım
        // 2/C
       // @OneToOne(cascade = CascadeType.ALL)
       // private Musteri musteri;     sipariş sınıfın da onetoone da çalışıyor
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            String sql= "select m.musteriid, count(*) as siparisler from hibernate_marathon2.Siparis as s\n" +
                    "inner join hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                    "inner join hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                    "inner join hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                    "inner join hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                    "where m.musteriid =:aa";
                Query query = session.createNativeQuery(sql);
                query.setParameter("aa",musteriId);
                List<Object[]> siparisList = query.getResultList();
                for (Object[] item : siparisList) {
                    System.out.println("===================");
                    System.out.println(
                                    " musteri id: " + item[0] +
                                    " urun adedi: " + item[1]
                    );
                }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("sorgu başarısız!!!");
        }
    }
    public void musteriIsimSiparisNo(){
        // 2/D
        // @OneToOne(cascade = CascadeType.ALL)
        // private Musteri musteri;     sipariş sınıfın da onetoone da çalışıyor
        String sql= "select s.id, sk.sipariskalemiid ,m.musteriIsmi,m.musteriSoyisim,m.musteriid ,u.urunIsmi,u.fiyat,sk.urunAdedi from hibernate_marathon2.Siparis as s\n" +
                "inner join hibernate_marathon2.Musteri as m on m.musteriid = musteri_musteriid\n" +
                "inner join hibernate_marathon2.Siparis_SiparisKalemi as ssk on ssk.Siparis_id = s.id\n" +
                "inner join hibernate_marathon2.SiparisKalemi as sk on siparisKalemiList_sipariskalemiid = sk.sipariskalemiid\n" +
                "inner join hibernate_marathon2.Urun as u on sk.sipariskalemiid = u.urunid\n" +
                "";
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            Query query = session.createNativeQuery(sql);
            List<Object[]> siparisList = query.getResultList();
            for (Object[] item : siparisList) {
                System.out.println("===================");
                System.out.println(
                        " sipariş id: " + item[0] +
                                " sipariş kalem id : " + item[1] +
                                " müsteri adı : " + item[2] +
                                " musteri soyadı: " + item[3]
                );
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("hata");
        }
    }
    public List<Siparis> getAll2() {
        // 2/A
        Transaction transaction = null;
        List<Siparis> list = null;
        try(Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
               // transaction.rollback();
            }
        }
        return list;
    }
}
