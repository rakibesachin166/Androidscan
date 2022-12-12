package com.sacdev.liveedgedetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import info.hannes.liveedgedetection.ScanConstants;
import info.hannes.liveedgedetection.activity.ScanActivity;

public class MainActivity extends AppCompatActivity {
 ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        startActivityForResult(new Intent(this, ScanActivity.class), 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 100  && resultCode  == RESULT_OK) {
                 try {
                     String requiredValue = data.getStringExtra(ScanConstants.SCANNED_RESULT);
                    // Uri sachin =  data.getData();
//                val filePath = data?.extras?.getString(ScanConstants.SCANNED_RESULT);
//                 baseBitMap = sachin.bit
                     imageView.setImageURI(Uri.parse(requiredValue));
                 }catch(Exception e ){
                     Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                 }

            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }
}
