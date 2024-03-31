package com.banner_world;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class Fullimage extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1000;
    private ImageView fullimagebanner;
    private Button download,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        getSupportActionBar().hide();
        fullimagebanner = findViewById(R.id.fullimage);
        download = findViewById(R.id.download);
        share = findViewById(R.id.share);
//        ActivityCompat.requestPermissions(Fullimage.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullimagebanner);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            int re_image = bundle.getInt("image");
            fullimagebanner.setImageResource(re_image);
        }
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage();
//                    Toast.makeText(Fullimage.this, "You click on download", Toast.LENGTH_SHORT).show();

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image();
            }
        });
    }

    private  void saveImage(){


        try {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) fullimagebanner.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            // Save image to gallery
            String savedImageURL = MediaStore.Images.Media.insertImage(
                    getContentResolver(),
                    bitmap,
                    "Banner",
                    "Banner"
            );
            // Parse the gallery image url to uri
            Uri savedImageURI = Uri.parse(savedImageURL);
            // Display the saved image to ImageView
            fullimagebanner.setImageURI(savedImageURI);
            Toast.makeText(Fullimage.this, "Image is Stored in gallary", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void image(){
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy((builder.build()));
        BitmapDrawable drawable = (BitmapDrawable) fullimagebanner.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        File f = new File(getExternalCacheDir()+"/"+getResources().getString(R.string.app_name)+".png");
        Intent shareint;
        try{
            FileOutputStream outputStream= new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            shareint = new Intent(Intent.ACTION_SEND);
            shareint.setType("image/*");
            shareint.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
            shareint.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        startActivity(Intent.createChooser(shareint,"Share Image"));
    }
}