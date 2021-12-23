package com.example.roko;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class kullaniciforberber extends AppCompatActivity {
    Profile p;
    MyAdapter adapter;
    ArrayList<Profile> list;
    RecyclerView recyclerView;
    String TAG = "cc";
    String city, town;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = firebaseDatabase.getReference();
    Denemesiralamaisyerleri deneme = new Denemesiralamaisyerleri();
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullaniciforberber);
        id = firebaseUser.getUid();
        Log.d(TAG, id);
        DatabaseReference userdata = FirebaseDatabase.getInstance().getReference().child("Kullanicilar").child(id);
        ValueEventListener rdn = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {     //read user info from database
                deneme = dataSnapshot.getValue(Denemesiralamaisyerleri.class);
                city = deneme.getIli();
                town = deneme.getIlcesi();
                Usevalue(city, town);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(kullaniciforberber.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        userdata.addValueEventListener(rdn);

    }

    private void Usevalue(String city, String town) {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<Profile>();
        DatabaseReference readBerber = FirebaseDatabase.getInstance().getReference().child("isletmeberber").child(city).child(town);
        ValueEventListener rcd = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    p = ds.getValue(Profile.class);
                    final String ideninaq=p.getIdesi();
                 list.add(p);

                }
                adapter=new MyAdapter(kullaniciforberber.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        readBerber.addListenerForSingleValueEvent(rcd);

    }


}

