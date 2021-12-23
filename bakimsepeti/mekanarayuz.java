package com.example.roko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class mekanarayuz extends AppCompatActivity {
    musteri m;
    Databaseuserbilgiler dtm;
    mekanarayuzrecy adapter;
    yazilacakmusteriler yazmusteri;
   private FirebaseDatabase database = FirebaseDatabase.getInstance();
private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
private FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
private StorageReference storageReference=firebaseStorage.getReference();
Button profilfotoek,yorumlar,islemler,modelfoto;
    RecyclerView recyclerViewmus;
    ArrayList<yazilacakmusteriler> yazmus;
    ArrayList<musteri> mus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mekanarayuz);
        profilfotoek=(Button)findViewById(R.id.Photoad);
        yazmus=new ArrayList<yazilacakmusteriler>();
        mus=new ArrayList<musteri>();
        yorumlar=(Button)findViewById(R.id.Comment);
        islemler=(Button)findViewById(R.id.islem);
        modelfoto=(Button)findViewById(R.id.modelfoto);
        recyclerViewmus=(RecyclerView)findViewById(R.id.musteriler);
        String id=firebaseAuth.getUid();
        System.out.println("bokvar");
        FirebaseDatabase firebaseDatabase3=FirebaseDatabase.getInstance();
        DatabaseReference mkk=firebaseDatabase3.getReference(id).child("müsteriler");
        ValueEventListener vmm=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for (DataSnapshot dataSnapshot2:dataSnapshot.getChildren()){
                 m=dataSnapshot2.getValue(musteri.class);
                 String musidesi=m.getIde();
                 String mussaati=m.getGeliceksaat();
                 String musislem=m.getIslem();
                 yazmusteri.setGeliceksaat(mussaati);
                 yazmusteri.setIslem(musislem);
                 System.out.println(musidesi);
                 FirebaseDatabase firebaseDatabase4=FirebaseDatabase.getInstance();
                 DatabaseReference mkm=firebaseDatabase4.getReference("Kullanicilar").child(musidesi);
                 ValueEventListener vtm=new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         for(DataSnapshot dataSnapshot3:dataSnapshot.getChildren()){
                             dtm=dataSnapshot3.getValue(Databaseuserbilgiler.class);
                             String isimsoy=dtm.getIsimsoyisim();
                             String telno=dtm.getTelefonnumarasi();
                             yazmusteri.setIsimsoy(isimsoy);
                             yazmusteri.setTelno(telno);
                             yazmus.add(yazmusteri);
                         }
                         adapter=new mekanarayuzrecy(mekanarayuz.this,yazmus);
                         recyclerViewmus.setAdapter(adapter);

                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 };mkm.addValueEventListener(vtm);
             }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };mkk.addValueEventListener(vmm);


        islemler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenet=new Intent(mekanarayuz.this,yapilacakis.class);
                startActivity(intenet);
            }
        });
        profilfotoek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intenet2=new Intent(mekanarayuz.this,profilepicadd.class);
startActivity(intenet2);
            }
        });
        modelfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenet3=new Intent(mekanarayuz.this,Modelfotoadd.class);
                startActivity(intenet3);
            }
        });



    }
    public void upload(View view){

    }
}
