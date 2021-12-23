package com.example.roko;

public class yazilacakmusteriler {
    private String isimsoy;
    private String telno;
    private String islem;
    private String geliceksaat;
    private String fiyati;

    public yazilacakmusteriler(String isimsoy, String telno, String islem, String geliceksaat, String fiyati) {
        this.isimsoy = isimsoy;
        this.telno = telno;
        this.islem = islem;
        this.geliceksaat = geliceksaat;
        this.fiyati = fiyati;
    }

    public String getIsimsoy() {
        return isimsoy;
    }

    public void setIsimsoy(String isimsoy) {
        this.isimsoy = isimsoy;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getIslem() {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

    public String getGeliceksaat() {
        return geliceksaat;
    }

    public void setGeliceksaat(String geliceksaat) {
        this.geliceksaat = geliceksaat;
    }

    public String getFiyati() {
        return fiyati;
    }

    public void setFiyati(String fiyati) {
        this.fiyati = fiyati;
    }
}
