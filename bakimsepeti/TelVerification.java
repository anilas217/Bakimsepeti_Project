package com.example.roko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.rpc.Code;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TelVerification extends AppCompatActivity {
    Button tamam, kaydet;
    EditText telkodu, telno;
String Codesent;
FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Kullanicilar");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_verification);
        tamam = (Button) findViewById(R.id.tamam);
        telkodu = (EditText) findViewById(R.id.telkodu);
        kaydet = (Button) findViewById(R.id.kaydet);
        telno = (EditText) findViewById(R.id.telno);
        mAuth = FirebaseAuth.getInstance();
        tamam.setOnClickListener(new View.OnClickListener() {                   //send verification code
            @Override
            public void onClick(View v) {
                sendverificationCode();
            }
        });
        kaydet.setOnClickListener(new View.OnClickListener() {               //kodu girip kaydı tamamlarsa eğer
            @Override
            public void onClick(View v) {
                kayditamamla();
            }
        });
    }
private void kayditamamla(){
        String code12=telkodu.getText().toString();
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(Codesent,code12);
    signInWithPhoneAuthCredential(credential);
}
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {             //sign the user
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                          Toast.makeText(TelVerification.this,"Kayıt başarıyla oluşturuldu",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(TelVerification.this,"Kayıt oluşturulamadı tekrar deneyin",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void sendverificationCode() {
        String tel = telno.getText().toString();
        if (tel.isEmpty()) {
            Toast.makeText(TelVerification.this, "Lütfen telefon numarasıni girin", Toast.LENGTH_LONG).show();
            return;
        } else {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(tel, 120, TimeUnit.SECONDS, this, mCallbacks);
            Toast.makeText(TelVerification.this, "Code Sent", Toast.LENGTH_SHORT).show();

        }
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {       //Telefon kodu basarılı olursa eger
Toast.makeText(TelVerification.this,"Kayıt başarıyla oluşturuldu",Toast.LENGTH_LONG).show();
Intent gitYerarama=new Intent(TelVerification.this,YerArama.class);
            KullaniciBilgiler kullanici=new KullaniciBilgiler();
            String id= UUID.randomUUID().toString();
            String il=getIntent().getStringExtra("il");
            String ilce=getIntent().getStringExtra("ilce");
            String isimsoy=getIntent().getStringExtra("isimsoy");
            String mail=getIntent().getStringExtra("maille");
            String tel2 = telno.getText().toString();
            kullanici.setMailadresi(mail);                //kullanici 1   mail
            kullanici.setIsimsoyisim(isimsoy);            //kullanici 2   isimsoy
            kullanici.setTelefonnumarasi(tel2);           //kullanici 3   telefon numarası
           myRef.child(il).child(ilce).child(id).setValue(kullanici);

startActivity(gitYerarama);
// finish();
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
Toast.makeText(TelVerification.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            Codesent = s;
        }
    };
}


