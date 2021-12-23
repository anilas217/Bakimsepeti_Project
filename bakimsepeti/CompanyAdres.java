package com.example.roko;

public class CompanyAdres {
    private String idesi;
   private String adres;
   private String calisanisim;
   private String Telno;
   private String mekanisim;

    public CompanyAdres() {

    }

    public CompanyAdres(String idesi, String adres, String calisanisim, String telno, String mekanisim) {
        this.idesi = idesi;
        this.adres = adres;
        this.calisanisim = calisanisim;
        Telno = telno;
        this.mekanisim = mekanisim;
    }

    public String getIdesi() {
        return idesi;
    }

    public void setIdesi(String idesi) {
        this.idesi = idesi;
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

    public String getTelno() {
        return Telno;
    }

    public void setTelno(String telno) {
        Telno = telno;
    }

    public String getMekanisim() {
        return mekanisim;
    }

    public void setMekanisim(String mekanisim) {
        this.mekanisim = mekanisim;
    }
}
