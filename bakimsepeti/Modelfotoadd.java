package com.example.roko;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Modelfotoadd extends AppCompatActivity {
Button yükle;
EditText modelname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelfotoadd);
        yükle=(Button)findViewById(R.id.Yükle);
        modelname=(EditText)findViewById(R.id.Modeladi);
        yükle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(Modelfotoadd.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Modelfotoadd.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                    return;
                }
                Intent intenet1=new Intent(Intent.ACTION_GET_CONTENT);
                intenet1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intenet1.setType("Modelfoto");
                startActivityForResult(intenet1,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            final ImageView imageView=findViewById(R.id.addmodelfoto);
            final List<Bitmap> bitmaps=new ArrayList<>();
            ClipData clipData=data.getClipData();
            if(clipData !=null){
                for(int i=0;i<clipData.getItemCount();i++){
                    Uri imageUri=clipData.getItemAt(i).getUri();
                    try {
                        InputStream is=getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap= BitmapFactory.decodeStream(is);
                        bitmaps.add(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
             Uri imageUri=data.getData();
                try {
                    InputStream is=getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap=BitmapFactory.decodeStream(is);
                    bitmaps.add(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(final Bitmap b:bitmaps){
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        imageView.setImageBitmap(b);

    }
});
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
