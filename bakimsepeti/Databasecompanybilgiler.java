package com.example.roko;

public class Databasecompanybilgiler {
    private String id;
    private String adres;
    private String calisanisim;
    private String mekanisim;
    private String telefon;

    public Databasecompanybilgiler() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getCalisanisim() {
        return calisanisim;
    }

    public void setCalisanisim(String calisanisim) {
        this.calisanisim = calisanisim;
    }

    public String getMekanisim() {
        return mekanisim;
    }

    public void setMekanisim(String mekanisim) {
        this.mekanisim = mekanisim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
