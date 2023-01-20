package com.bilgeadam.Soru2.repository;

public interface ICrud<T> {
    void save(T t);
    void getAll();
}
