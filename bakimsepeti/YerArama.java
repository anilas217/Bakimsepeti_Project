package com.example.roko;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.util.Calendar;
import java.util.Date;

import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class YerArama extends AppCompatActivity {
Button kuafor,berber,isletmemvar,konum;
TextView islem,gitsaat;
    StringBuilder sonuc;
    TimePicker tpSonuc;
    int saat,daki;
boolean control;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {    //second week-third week
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_arama);
        berber=(Button)findViewById(R.id.berber);
        konum=(Button)findViewById(R.id.Konumu);
        islem=(TextView)findViewById(R.id.Yapilacakislem);
        gitsaat=(TextView)findViewById(R.id.Gidileceksaat);
        kuafor=(Button)findViewById(R.id.kuafor);
        isletmemvar=(Button)findViewById(R.id.isletme);
        Intent intenet31=getIntent();
        Calendar simdikiZaman=Calendar.getInstance();
        String Time = java.text.DateFormat.getTimeInstance().format(new Date());
        System.out.println(Time);
        Date currentTime = Calendar.getInstance().getTime();
        String mekanidesi=intenet31.getStringExtra("mekanidesi");
        String gidileceksaat=intenet31.getStringExtra("gidileceksaat");
        String totalislemler=intenet31.getStringExtra("islemler");

        if(mekanidesi==null){

        }
        else{
            konum.setVisibility(View.VISIBLE);
            gitsaat.setVisibility(View.VISIBLE);
            islem.setVisibility(View.VISIBLE);
            gitsaat.setText("Şu saatte orda olmalısınız:"+"\n"+gidileceksaat);
            islem.setText(totalislemler);
            boolean control=true;


        }
        if(control==true){

        }


        konum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        berber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent goBerber=new Intent(YerArama.this,kullaniciforberber.class);
startActivity(goBerber);
            }
        });

        isletmemvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gokaiyt;
                gokaiyt = new Intent(YerArama.this,isletme_kayit.class);
                startActivity(gokaiyt);
                finish();
            }
        });
        kuafor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gokuafor=new Intent(YerArama.this, UserİnterfaceKuafor.class);
                startActivity(gokuafor);
                finish();
            }
        });

            }

    private void StartService(Intent intenet3) {


    }

}
