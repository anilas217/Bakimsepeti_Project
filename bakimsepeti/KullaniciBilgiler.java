package com.example.roko;

public class KullaniciBilgiler {
    private String isimsoyisim;
    private String telefonnumarasi;
    private String mailadresi;
    private String ili;
    private String ilcesi;

    public KullaniciBilgiler(String isimsoyisim, String telefonnumarasi, String mailadresi, String ili, String ilcesi) {
        this.isimsoyisim = isimsoyisim;
        this.telefonnumarasi = telefonnumarasi;
        this.mailadresi = mailadresi;
        this.ili = ili;
        this.ilcesi = ilcesi;
    }

    public KullaniciBilgiler() {

    }

    public String getIsimsoyisim() {
        return isimsoyisim;
    }

    public void setIsimsoyisim(String isimsoyisim) {
        this.isimsoyisim = isimsoyisim;
    }

    public String getTelefonnumarasi() {
        return telefonnumarasi;
    }

    public void setTelefonnumarasi(String telefonnumarasi) {
        this.telefonnumarasi = telefonnumarasi;
    }

    public String getMailadresi() {
        return mailadresi;
    }

    public void setMailadresi(String mailadresi) {
        this.mailadresi = mailadresi;
    }

    public String getIli() {
        return ili;
    }

    public void setIli(String ili) {
        this.ili = ili;
    }

    public String getIlcesi() {
        return ilcesi;
    }

    public void setIlcesi(String ilcesi) {
        this.ilcesi = ilcesi;
    }
}