package com.example.roko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Ayarlar extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.ayarlarsettings,menu);
        return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.Exit){
            firebaseAuth.signOut();
        }
        else if(item.getItemId()==R.id.Changecounty){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_arama);
        firebaseAuth=FirebaseAuth.getInstance();
         Intent intenet=new Intent(Ayarlar.this,MainActivity.class);
         startActivity(intenet);
    }
}
