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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
EditText mail,sifre;
Button giris,kayit;
private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
       mail=(EditText)findViewById(R.id.editTexthiz1);
       sifre=(EditText)findViewById(R.id.editTexthiz2);
       giris=(Button)findViewById(R.id.giris);
       kayit=(Button)findViewById(R.id.kayit1);
      FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
       if(firebaseUser != null){
           Intent intenet=new Intent(MainActivity.this,YerArama.class);
           startActivity(intenet);
           // finish();
       }
       kayit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intenet3=new Intent(MainActivity.this,Kayit.class);
               startActivity(intenet3);
           }
       });
       giris.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
String kulmail=mail.getText().toString();
String kulsifre=sifre.getText().toString();
firebaseAuth.signInWithEmailAndPassword(kulmail,kulsifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
    @Override
    public void onSuccess(AuthResult authResult) {
       Toast.makeText(MainActivity.this,"Giriş başarılı",Toast.LENGTH_LONG).show();
       Intent GitYere=new Intent(MainActivity.this,YerArama.class);
       startActivity(GitYere);
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(MainActivity.this,"Sifre ya da mail adresi yanlış",Toast.LENGTH_LONG).show();
    }
});
           }
       });
    }

}
