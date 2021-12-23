package com.example.roko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class yapilacakis extends AppCompatActivity {
   EditText fiyat,sure,is;
   Button ekle,geri;
   Normalislemlerclassi islemler=new Normalislemlerclassi();
  FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
  DatabaseReference myref=firebaseDatabase.getReference("isletme");
  FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
  String idesi=firebaseAuth.getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yapilacakis);
        fiyat=(EditText)findViewById(R.id.fiyat);
        sure=(EditText)findViewById(R.id.sure);
        is=(EditText)findViewById(R.id.yapilacakis);
        geri=(Button)findViewById(R.id.geri);
        ekle=(Button)findViewById(R.id.ekle);
        final String ide=firebaseAuth.getUid();
        ekle.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String controlfiyat = fiyat.getText().toString();
                                        String controlsure = sure.getText().toString();
                                        final String controlis = is.getText().toString();
                                        if (controlfiyat.isEmpty()) {
                                            Toast.makeText(yapilacakis.this, "Lütfen fiyatı yazın", Toast.LENGTH_LONG).show();
                                        } else if (controlsure.isEmpty()) {
                                            Toast.makeText(yapilacakis.this, "Lütfen süresini girin", Toast.LENGTH_LONG).show();
                                        } else if (controlis.isEmpty()) {
                                            Toast.makeText(yapilacakis.this, "Lütfen yapılacak işi yazın", Toast.LENGTH_LONG).show();
                                        } else {
                                            islemler.setFiyati(controlfiyat);
                                            islemler.setIşlemintürü(controlis);
                                            islemler.setSüresi(controlsure);
                                            myref.child(idesi).child("permisson").addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    String control = String.valueOf(dataSnapshot.getValue());
                                                    if (control.contentEquals("false")) {
                                                        FirebaseDatabase sll=FirebaseDatabase.getInstance();
                                                        DatabaseReference lol=sll.getReference();
                                                        String valuesi = "true";
                                                        lol.child("isletme").child(idesi).child("permisson").setValue(valuesi);
                                                        FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
                                                        FirebaseDatabase firebaseDatabase2=FirebaseDatabase.getInstance();
                                                        DatabaseReference zamansaatleri=firebaseDatabase2.getReference();
                                                        String asd=UUID.randomUUID().toString();
                                                        zamansaatleri.child(idesi).child("saatleri").child(asd).setValue("10.00-19.00");
                                                        DatabaseReference ekleme = firebaseDatabase1.getReference();
                                                        ekleme.child(idesi).child("Yapilan islemler").child(controlis).setValue(islemler);
                                                        Toast.makeText(yapilacakis.this, "İşlemleriniz başarıyla eklendi", Toast.LENGTH_LONG).show();
                                                        fiyat.getText().clear();
                                                        sure.getText().clear();
                                                        is.getText().clear();
                                                    } else {
                                                        FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
                                                        DatabaseReference ekleme = firebaseDatabase1.getReference();
                                                        ekleme.child(idesi).child("Yapilan islemler").child(controlis).setValue(islemler);
                                                        Toast.makeText(yapilacakis.this, "İşlemleriniz başarıyla eklendi", Toast.LENGTH_LONG).show();
                                                        fiyat.getText().clear();
                                                        sure.getText().clear();
                                                        is.getText().clear();
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        }
                                    }
                                });



        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenet=new Intent(yapilacakis.this,mekanarayuz.class);
                startActivity(intenet);
            }
        });
    }
}
