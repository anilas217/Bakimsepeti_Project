package com.example.roko;

public class Normalislemlerclassi {
    private String işlemintürü;
    private String Fiyati;
    private String Süresi;

    public Normalislemlerclassi() {

    }

    public Normalislemlerclassi(String işlemintürü, String fiyati, String süresi) {
        this.işlemintürü = işlemintürü;
        this.Fiyati = fiyati;
        this.Süresi = süresi;


    }

    public String getIşlemintürü() {
        return işlemintürü;
    }

    public void setIşlemintürü(String işlemintürü) {
        this.işlemintürü = işlemintürü;
    }

    public String getFiyati() {
        return Fiyati;
    }

    public void setFiyati(String fiyati) {
        Fiyati = fiyati;
    }

    public String getSüresi() {
        return Süresi;
    }

    public void setSüresi(String süresi) {
        Süresi = süresi;
    }
}

