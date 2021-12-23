package com.example.roko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class isletme_kayit extends AppCompatActivity {
EditText phonennum,isyeriisim,calisanisim;
CheckBox kuafor,berber;
Button ileri;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("isletme");
    companyclass isletmesinifi=new companyclass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isletme_kayit2);
        ileri=(Button)findViewById(R.id.ileri);
        phonennum=(EditText)findViewById(R.id.phonenum);
        isyeriisim=(EditText)findViewById(R.id.isyeriisim);
        calisanisim=(EditText)findViewById(R.id.workername);
        kuafor=(CheckBox)findViewById(R.id.checkkuaf);
        berber=(CheckBox)findViewById(R.id.checkberber);
        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonnnumbe=phonennum.getText().toString();
                String isyericalis=calisanisim.getText().toString();
                String companyname=isyeriisim.getText().toString();
                if(phonnnumbe.isEmpty()){
                    Toast.makeText(isletme_kayit.this,"Lütfen telefon numarasını girin",Toast.LENGTH_LONG).show();

                }
                else if(isyericalis.isEmpty()){
                    Toast.makeText(isletme_kayit.this,"Lütfen calisanin ismini girin",Toast.LENGTH_LONG).show();
                }
                else if(companyname.isEmpty()){
                    Toast.makeText(isletme_kayit.this,"Lütfen is yeri isimini girin",Toast.LENGTH_LONG).show();
                }
                else if(kuafor.isChecked()){
                    if(berber.isChecked()){
                        Toast.makeText(isletme_kayit.this,"Sadece bir tane seçebilirsiniz",Toast.LENGTH_LONG).show();
                    }
                    else{
                        isletmesinifi.setCompname(companyname);
                        isletmesinifi.setEmployename(isyericalis);
                        isletmesinifi.setPhonenumm(phonnnumbe);
                        String uniqueId = UUID.randomUUID().toString();
                        isletmesinifi.setId(uniqueId);
                        isletmesinifi.setType("kuafor");
                       // myRef.child("kuafor").child(uniqueId).setValue(isletmesinifi);
                        Toast.makeText(isletme_kayit.this,"kayıt oluşturuldu şimdi adreslere geçelim",Toast.LENGTH_LONG).show();
                        Intent newintent1=new Intent(isletme_kayit.this,kuaforbilgiler.class);
                        newintent1.putExtra("Compname",companyname);
                        newintent1.putExtra("Employename",isyericalis);
                        newintent1.putExtra("Phonenumm",phonnnumbe);
                        startActivity(newintent1);
                        finish();
                    }
                }
                else if(berber.isChecked()){
                    if(kuafor.isChecked()){
                        Toast.makeText(isletme_kayit.this,"Sadece bir tane seçebilirsiniz",Toast.LENGTH_LONG).show();
                    }
                    else{
                        isletmesinifi.setCompname(companyname);
                        isletmesinifi.setEmployename(isyericalis);
                        isletmesinifi.setPhonenumm(phonnnumbe);
                        String uniqueId = UUID.randomUUID().toString();
                        isletmesinifi.setId(uniqueId);
                        isletmesinifi.setType("berber");
                       // myRef.child("berber").child(uniqueId).setValue(isletmesinifi);
                        Toast.makeText(isletme_kayit.this,"kayıt oluşturuldu şimdi adreslere geçelim.",Toast.LENGTH_LONG).show();

                         Intent newintent = new Intent(isletme_kayit.this, Berberbilgiler.class);
                         newintent.putExtra("compname",companyname);
                         newintent.putExtra("employename",isyericalis);
                         newintent.putExtra("phonenum",phonnnumbe);
                         startActivity(newintent);
                         finish();

                    }
                }


            }
        });

    }
}
