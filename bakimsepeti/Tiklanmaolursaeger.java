package com.example.roko;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Tiklanmaolursaeger extends AppCompatActivity {
    StringBuffer sb=null;
ArrayList<Normalislemlerclassi> list;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference myRef=firebaseDatabase.getReference();
Button mekaninfotolari,Modeller,Konumu,ileri;
userchooseProcess adapter2;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiklanmaolursaeger);
        mekaninfotolari=(Button)findViewById(R.id.Mekaninfotolari);

        Modeller=(Button)findViewById(R.id.Modeller);
        Konumu=(Button)findViewById(R.id.Konumu);
        ileri=(Button)findViewById(R.id.Tamam);
        recyclerView=(RecyclerView)findViewById(R.id.İşlemleri);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final Intent intent=getIntent();
       list=new ArrayList<Normalislemlerclassi>();
        final String Searchide=intent.getStringExtra("idisi");
        System.out.println(Searchide);
        DatabaseReference myRef=FirebaseDatabase.getInstance().getReference(Searchide).child("Yapilan islemler");
        ValueEventListener rcd=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Normalislemlerclassi n=dataSnapshot1.getValue(Normalislemlerclassi.class);
                    list.add(n);
                }
                adapter2=new userchooseProcess(Tiklanmaolursaeger.this,list);
                recyclerView.setAdapter(adapter2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        myRef.addListenerForSingleValueEvent(rcd);




        mekaninfotolari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Modeller.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        });
        Konumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb=new StringBuffer();
                for(Normalislemlerclassi nl:adapter2.CheckedPlayers){
                    if(adapter2.CheckedPlayers.size()==0){
                        Toast.makeText(Tiklanmaolursaeger.this,"Lütfen hizmetleri seçin",Toast.LENGTH_LONG).show();
                    }
                    else{
                        sb.append(nl.getIşlemintürü()+" ");
                        sb.append(nl.getFiyati()+" ");
                        sb.append(nl.getSüresi()+" ");
                        sb.append("mokoko ");
                        Intent intent=new Intent(Tiklanmaolursaeger.this,Zamansecme.class);
                        intent.putExtra("isyeriidesi",Searchide);
                        intent.putExtra("İstenen islemler", (Serializable) sb);
                        startActivity(intent);

                    }

                }
            }
        });


    }
}
