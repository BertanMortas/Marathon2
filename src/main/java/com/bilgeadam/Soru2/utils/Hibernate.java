package com.bilgeadam.Soru2.utils;

import com.bilgeadam.Soru2.entity.Musteri;
import com.bilgeadam.Soru2.entity.Siparis;
import com.bilgeadam.Soru2.entity.SiparisKalemi;
import com.bilgeadam.Soru2.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Siparis.class);
                configuration.addAnnotatedClass(SiparisKalemi.class);
                configuration.addAnnotatedClass(Musteri.class);
                configuration.addAnnotatedClass(Urun.class);
                sessionFactory = configuration.configure("Hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
