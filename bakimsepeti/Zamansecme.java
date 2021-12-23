package com.example.roko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

public class Zamansecme extends AppCompatActivity {
    String TAG;
String sb;
    int finalselectedhours;
    int finalselectedminute;
Button islemonay;
    customerselecttime adapter3;
    RecyclerView recyclerView;
StringBuilder sonuc;
TimePicker tpSonuc;
int selectedtime;
int selectedminute;
ArrayList<Secilebilecekzamanlar> list;
ArrayList<Secilebilecekzamanlar> yeniliste;
TextView islemler,sure,fiyat,zamanyazma;
   String yazilacakislemler;
    int totalfiyat=0;
    int totaldakika=0;
    int saat;
    String zamanbakilcakide;
    int daki;
    String total;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamansecme);
        zamanyazma=(TextView)findViewById(R.id.zamanyazma);
        recyclerView=(RecyclerView)findViewById(R.id.Zamanrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sure=(TextView)findViewById(R.id.Totalmin);
        fiyat=(TextView)findViewById(R.id.Totalprice);
        islemler=(TextView)findViewById(R.id.Totalprocess);
        tpSonuc=(TimePicker)findViewById(R.id.txtTime);
        islemonay=(Button)findViewById(R.id.Randevuyual);
        final String priceis=fiyat.getText().toString();
        Calendar simdikiZaman=Calendar.getInstance();
        list=new ArrayList<Secilebilecekzamanlar>();
        sonuc=new StringBuilder();
        tpSonuc.setIs24HourView(true);
       saat=simdikiZaman.get(Calendar.HOUR);
       daki=simdikiZaman.get(Calendar.MINUTE);
        sonuc.append(saat).append(":").append(daki);
        System.out.println(saat+" "+daki);
        final Intent intent=getIntent();
        sb= getIntent().getStringExtra("İstenen islemler");
        String[] aa=sb.split("mokoko");                   //Ayırma
            for(int i=0;i<aa.length-1;i++) {     //split line
                yazilacakislemler=null;
                String tt = aa[i];
                String[] olay = tt.split(" ");    // split space
                count = 0;
                for (int t = 0; t < olay.length; t++) {

                    try {
                        count++;
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        return;
                    }
                }
                    String dakika=olay[count-1];
                            String Fiyat=olay[count-2];
                            for(int g=0;g<count-2;g++){
                              try {
                                  if(olay[g].equals(null)){
                                      return;
                                  }
                                  else{
                                      if(yazilacakislemler==null){            //sonuna null atıyo bunun önüne geçmek için
                                          yazilacakislemler=olay[g]+" ";
                                      }else{
                                          yazilacakislemler=yazilacakislemler+" "+olay[g];
                                      }
                                  }
                              }
                              catch (ArrayIndexOutOfBoundsException exception){
                                  return;
                              }
                            }
                       if(total==null){
                           total=yazilacakislemler+"\n";
                       }
                       else{
                           total=yazilacakislemler+"\n"+total;
                       }

                            int m=Integer.parseInt(dakika);
                            totaldakika=totaldakika+m;
                            int yy=Integer.parseInt(Fiyat);
                            totalfiyat=totalfiyat+yy;
            }
            String dk=Integer.toString(totaldakika);
        sure.setText(dk+" Dakika");
        String fyt=Integer.toString(totalfiyat);
        fiyat.setText(fyt+" Tl");
        islemler.setText(total);
        zamanyazma.setText("Lütfen gitmek istediğiniz saati seçin ve süreniz "+dk+" dakika olmak üzere bi zaman dilimi olması gerek");
        zamanbakilcakide= getIntent().getStringExtra("isyeriidesi");
        FirebaseDatabase firebaseDatabase3=FirebaseDatabase.getInstance();
        DatabaseReference mkk=firebaseDatabase3.getReference(zamanbakilcakide).child("saatleri");
        ValueEventListener rmd=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot2:dataSnapshot.getChildren()){
                    System.out.println(totaldakika);
                   String Sr=dataSnapshot2.getValue(String.class);         //dakika string convert ve bakma
                   String[] top=Sr.split("-");
                   String gir=top[0];
                   String cik=top[1];
                   int eklenceksaat=totaldakika/60;
                   int eklencekdakika=totaldakika%60;
                   String[] girenstring=gir.split(Pattern.quote("."));
                   String[] çikastring=cik.split(Pattern.quote("."));
                   String çıkaninsaatstring=çikastring[0];
                   String çıkanindakikastring=çikastring[1];
                   int çıkansaat=Integer.parseInt(çıkaninsaatstring);
                   int çıkandakika=Integer.parseInt(çıkanindakikastring);
                   String gireninsaatstring=girenstring[0];
                   String girenindakikastring=girenstring[1];
                   int girensaat=Integer.parseInt(gireninsaatstring);
                   int girendakika=Integer.parseInt(girenindakikastring);
                   girensaat=girensaat+eklenceksaat;
                   girendakika=girendakika+eklencekdakika;
                   if(çıkansaat==girensaat){
                       if(çıkandakika>=girendakika){
                           Secilebilecekzamanlar S=new Secilebilecekzamanlar();
                           S.setGiris(gir);
                           S.setCikis(cik);
                           list.add(S);
                           System.out.println("burdayım");
                       }
                   }
                   else if(çıkansaat>girensaat){
                       Secilebilecekzamanlar S=new Secilebilecekzamanlar();
                       S.setGiris(gir);
                       S.setCikis(cik);
                       list.add(S);

                   }
                   else {

                   }


                }
                adapter3=new customerselecttime(Zamansecme.this,list);
                recyclerView.setAdapter(adapter3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };mkk.addValueEventListener(rmd);
        islemonay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(selectedtime + " " + selectedminute);
                System.out.println(saat + " " + daki);
                if (saat > selectedtime) {
                    Toast.makeText(Zamansecme.this, "Şuan ki saatin altında bir saat dilimi seçemessiniz", Toast.LENGTH_LONG).show();
                    return;
                } else if (saat == selectedtime) {
                    if (daki > selectedminute) {
                        Toast.makeText(Zamansecme.this, "Şuan ki saatin altında bir saat dilimi seçemessiniz", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        String[] hh=list.get(i).getGiris().split(Pattern.quote("."));
                        String[] cc=list.get(i).getCikis().split(Pattern.quote("."));
                       int first=Integer.parseInt(hh[0]);
                       int sec=Integer.parseInt(hh[1]);
                       int finalfirsttime=Integer.parseInt(cc[0]);
                       int finalsecminute=Integer.parseInt(cc[1]);
                       finalselectedhours=selectedtime;
                       finalselectedminute=selectedminute;
                       int artanminute;
                       // başlangıç aralık başlangıc arasında mı kontrol
                        if(totaldakika<60){                                          //doğru bu
                             artanminute=selectedminute+totaldakika;
                            if(artanminute>=60){
                                finalselectedhours++;
                                finalselectedminute=artanminute%60;
                            }
                            else{
                                finalselectedminute=artanminute;
                            }
                        }
                        else if(totaldakika>=60){
                            int artcaksaat=totaldakika/60;
                            finalselectedhours=artcaksaat+finalselectedhours;
                            int artanminutee=selectedminute+totaldakika;
                            if(artanminutee>=60){
                                finalselectedminute=artanminutee%60;
                            }
                            else{


                            }

                        }

                  //     int totaledogru=totaldakika/60;
                   //    int totalmin=totaldakika%60;
                    //   int controlmin=totalmin+selectedminute;


                       System.out.println(first+"."+sec);
                       System.out.println(selectedtime+"."+selectedminute);
                       System.out.println(finalselectedhours+"."+finalselectedminute);
                       System.out.println(finalfirsttime+"."+finalsecminute);

///// olay ufkuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
                        double tm=(double)selectedminute/100;
                        double A=selectedtime+(tm);       //12.40


                        double jj=(double)finalselectedminute/100;
                        double B=finalselectedhours+(jj);          //13.40

                        double mnm=(double)sec/100;
                        double C=first+(mnm);                          //12.30

                        double ssd=(double)finalsecminute/100;
                        double D=finalfirsttime+(ssd);                //21.00

                        if(A>C){
                            if(D>=B){
                               FirebaseDatabase firebaseDatabase1=FirebaseDatabase.getInstance();
                               DatabaseReference drt=firebaseDatabase1.getReference();
                               drt.child(zamanbakilcakide).child("saatleri").setValue(null);
                               if(list.size()==1){
                                   String no1=list.get(0).getGiris();
                                   String no2=String.valueOf(selectedtime+"."+selectedminute);
                                   String no3=String.valueOf(finalselectedhours+"."+finalselectedminute);
                                   String no4=String.valueOf(finalfirsttime+"."+finalsecminute);
                                   String dds=UUID.randomUUID().toString();
                                   drt.child(zamanbakilcakide).child("saatleri").child(dds).setValue(no3+"-"+no4);
                                   String asd=UUID.randomUUID().toString();
                                   drt.child(zamanbakilcakide).child("saatleri").child(asd).setValue(no1+"-"+no2);
                                   System.out.println("durum1");
                               }

                               else{                   //buralar sıkıntı kanka düzelt
                                   for(int gg=0;gg<i;gg++){
                                      String no1=list.get(gg).getGiris();
                                       String no2=list.get(gg).getCikis();
                                       String asd=UUID.randomUUID().toString();
                                       drt.child(zamanbakilcakide).child("saatleri").child(asd).setValue(no1+"-"+no2);
                                       System.out.println("durum2");
                                   }
                                   String no1=list.get(i).getGiris();
                                   String no2=String.valueOf(selectedtime+"."+selectedminute);
                                   String no3=String.valueOf(finalselectedhours+"."+finalselectedminute);
                                   String no4=String.valueOf(finalfirsttime+"."+finalsecminute);
                                   String dds=UUID.randomUUID().toString();
                                   drt.child(zamanbakilcakide).child("saatleri").child(dds).setValue(no3+"-"+no4);
                                  String asd=UUID.randomUUID().toString();
                                  drt.child(zamanbakilcakide).child("saatleri").child(asd).setValue(no1+"-"+no2);
                                   for(int tt=i+1;tt<list.size();tt++){
                                       String no5=list.get(tt).getGiris();
                                       String no6=list.get(tt).getCikis();
                                       String asde=UUID.randomUUID().toString();
                                       drt.child(zamanbakilcakide).child("saatleri").child(asde).setValue(no1+"-"+no2);


                                   }
                               }
                                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();             //müsteri onaylandı
                               String ide=firebaseAuth.getUid();
                               musteri msm=new musteri();
                               msm.setIde(ide);
                                String no2=String.valueOf(selectedtime+"."+selectedminute);
                               msm.setGeliceksaat(no2);
                               String koko=islemler.getText().toString();
                               msm.setIslem(koko);
                               msm.setFiyati(priceis);
                               String balik=UUID.randomUUID().toString();
                             FirebaseDatabase firebaseDatabase11=FirebaseDatabase.getInstance();
                                DatabaseReference dtg=firebaseDatabase11.getReference("Anlik müsteriler");
                                dtg.child(zamanbakilcakide).child("müsteriler").child(balik).setValue(msm);
                                System.out.println(msm);
                                Intent intenet=new Intent(Zamansecme.this,YerArama.class);
                                intenet.putExtra("mekanidesi",zamanbakilcakide);
                                intenet.putExtra("gidileceksaat",no2);
                                intenet.putExtra("islemler",koko);
                                startActivity(intenet);
                                Toast.makeText(Zamansecme.this,"Randevunuz başarıyla alındı",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(Zamansecme.this,"İşlemin süresi boş zaman aralığını açtı lütfen tekrar deneyin",Toast.LENGTH_LONG).show();
                            }
                        }
                    }


                }
            }
        });
        tpSonuc.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectedtime=hourOfDay;
                selectedminute=minute;
            }
        });

    }
}
