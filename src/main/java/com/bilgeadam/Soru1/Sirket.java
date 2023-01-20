package com.bilgeadam.Soru1;

public class Sirket {
    private int id;
    private String sirketismi; // datebasede ugrasmamak icin camelcase kullanmadım
    private String sirketsahibi;
    private String unvan;
    private String faaliet;
    private String kurulus;

    public Sirket(String sirketismi, String sirketsahibi, String unvan, String faaliet, String kurulus) {
        this.sirketismi = sirketismi;
        this.sirketsahibi = sirketsahibi;
        this.unvan = unvan;
        this.faaliet = faaliet;
        this.kurulus = kurulus;
    }

    public Sirket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSirketismi() {
        return sirketismi;
    }

    public void setSirketismi(String sirketismi) {
        this.sirketismi = sirketismi;
    }

    public String getSirketsahibi() {
        return sirketsahibi;
    }

    public void setSirketsahibi(String sirketsahibi) {
        this.sirketsahibi = sirketsahibi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getFaaliet() {
        return faaliet;
    }

    public void setFaaliet(String faaliet) {
        this.faaliet = faaliet;
    }

    public String getKurulus() {
        return kurulus;
    }

    public void setKurulus(String kurulus) {
        this.kurulus = kurulus;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", sirketismi='" + sirketismi + '\'' +
                ", sirketsahibi='" + sirketsahibi + '\'' +
                ", unvan='" + unvan + '\'' +
                ", faaliet='" + faaliet + '\'' +
                ", kurulus='" + kurulus + '\'' +
                '}';
    }
}
