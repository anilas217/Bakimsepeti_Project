package com.example.roko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;                //kral burda linearlayout u unutma
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;

public class Kayit extends AppCompatActivity {

EditText isim,mail,sifre,sifretekrar;
Button geri,kayit;

FirebaseAuth firebaseau;
KullaniciBilgiler kullanici=new KullaniciBilgiler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

isim=(EditText)findViewById(R.id.isimsoy);
mail=(EditText)findViewById(R.id.mailaut);
sifre=(EditText)findViewById(R.id.sifre1);
sifretekrar=(EditText)findViewById(R.id.sifre2);
geri=(Button)findViewById(R.id.geri);
kayit=(Button)findViewById(R.id.kaydol);
firebaseau=FirebaseAuth.getInstance();                             //email
final FirebaseAuthSettings firebaseAuthSettings=firebaseau.getFirebaseAuthSettings();         //telefon numarası
geri.setOnClickListener(new View.OnClickListener() {                   //kayit için
    @Override
    public void onClick(View v) {
        Intent inte=new Intent(Kayit.this,MainActivity.class);
        startActivity(inte);
    }
});

kayit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String on1=sifre.getText().toString();
        String on2=sifretekrar.getText().toString();
        final String maille=mail.getText().toString();
        if(!(on1.contentEquals(on2))){
            Toast.makeText(Kayit.this,"Sifreler birbirinin aynısı degil",Toast.LENGTH_LONG).show();
        }
        else {
            firebaseau.createUserWithEmailAndPassword(maille, on1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    kullanici.setMailadresi(maille);
                    String isimsoy=isim.getText().toString();
                    kullanici.setIsimsoyisim(isimsoy);

Intent Tel=new Intent(Kayit.this,Kayit2.class);
Tel.putExtra("isimsoy",isimsoy);      //number 2
Tel.putExtra("mail",maille);          //number 3
startActivity(Tel);
 finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {                             //hata mesajı email
                    String error = e.getLocalizedMessage().toString();
                  //  String[] myStringArray = error.split(" ");
                    Toast.makeText(Kayit.this,error, Toast.LENGTH_LONG).show();
                 /*   if (myStringArray[0].contentEquals("The")) {
                        Toast.makeText(Kayit.this, "lütfen doğru mail adresi giriniz", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Kayit.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }   */
                }
            });
        }
    }
});
    }
}
