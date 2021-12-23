package com.example.roko;

public class Profile {
    private String idesi;
    private String mekanisim;
    private String telno;
    private String mekanadresi;
    private String calisanisim;
    private String puan;
    private String profilepic;

    public Profile() {

    }

    public Profile(String idesi, String mekanisim, String telno, String mekanadresi, String calisanisim, String puan, String profilepic) {
        this.idesi = idesi;
        this.mekanisim = mekanisim;
        this.telno = telno;
        this.mekanadresi = mekanadresi;
        this.calisanisim = calisanisim;
        this.puan = puan;
        this.profilepic = profilepic;
    }

    public String getIdesi() {
        return idesi;
    }

    public void setIde(String idesi) {
        this.idesi = idesi;
    }

    public String getMekanisim() {
        return mekanisim;
    }

    public void setMekanisim(String mekanisim) {
        this.mekanisim = mekanisim;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getMekanadresi() {
        return mekanadresi;
    }

    public void setMekanadresi(String mekanadresi) {
        this.mekanadresi = mekanadresi;
    }

    public String getCalisanisim() {
        return calisanisim;
    }

    public void setCalisanisim(String calisanisim) {
        this.calisanisim = calisanisim;
    }

    public String getPuan() {
        return puan;
    }

    public void setPuan(String puan) {
        this.puan = puan;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
}
