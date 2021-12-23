package com.example.roko;

import java.util.ArrayList;

public class musteri extends ArrayList<musteri> {
    private String ide;
    private String islem;
    private String geliceksaat;
    private String fiyati;

    public musteri() {

    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
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
