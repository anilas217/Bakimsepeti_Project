package com.example.roko;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.FontRequest;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.security.Permission;
import java.util.HashMap;

public class profilepicadd extends AppCompatActivity {
    String ide;
    Bitmap selectedimage;
    Uri imagedata;
    String TAG;
    Button geri, yükle;
    ImageView selectfoto;
    FirebaseStorage firebaseStorage=FirebaseStorage.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
  private static final int IMAGE_PICK_CODE=1000;
  private static final int PERMISSION_CODE=1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepicadd);
        ide=firebaseAuth.getUid();
        geri = (Button) findViewById(R.id.geri);
        yükle = (Button) findViewById(R.id.upload);
        selectfoto = (ImageView) findViewById(R.id.fotoselect);
        yükle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagedata == null) {
Toast.makeText(profilepicadd.this,"Lütfen fotoğrafı seçin",Toast.LENGTH_LONG).show();
                } else {
                    firebaseStorage.getReference(ide).child("Profil fotoğrafı").putFile(imagedata).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(profilepicadd.this,"Profil fotoğrafınız başarıyla eklendi",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
Toast.makeText(profilepicadd.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenet = (new Intent(profilepicadd.this, mekanarayuz.class));
                startActivity(intenet);
            }
        });

    }
    public void Fotosec(View view)  {
        if(ContextCompat.checkSelfPermission(profilepicadd.this, permission.READ_EXTERNAL_STORAGE) !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(profilepicadd.this,new String[]{permission.READ_EXTERNAL_STORAGE},1);
        }
        else{
            Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==1){
            if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Intent intentTogallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentTogallery,2);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2  && resultCode==RESULT_OK && data!=null){
Uri imageData=data.getData();
            try {
                if(Build.VERSION.SDK_INT>=28){
ImageDecoder.Source source=ImageDecoder.createSource(this.getContentResolver(),imageData);
selectedimage=ImageDecoder.decodeBitmap(source);
selectfoto.setImageBitmap(selectedimage);
                }else {
                    selectedimage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageData);
                    selectfoto.setImageBitmap(selectedimage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}