package com.bilgeadam.Soru2.repository;

import com.bilgeadam.Soru2.entity.Musteri;
import com.bilgeadam.Soru2.entity.Siparis;
import com.bilgeadam.Soru2.utils.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MusteriDao {
    public List<Musteri> getAll() {
        // 2/B
        Transaction transaction = null;
        List<Musteri> list = null;
        try(Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("select musteri from Musteri musteri").list();
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
