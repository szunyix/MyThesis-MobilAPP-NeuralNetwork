package com.szunyix.mythesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.szunyix.mythesis.image.ImageClassificationActivity;
import com.szunyix.mythesis.image.ObjectDetectionActivity;
import com.szunyix.mythesis.layout.CustomModelNavHelperActivity;
import com.szunyix.mythesis.layout.HelpGuideActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void onGotoImageActivity(View view){
        Intent intent = new Intent(this, ImageClassificationActivity.class);
        startActivity(intent);
    }

    public void onGotoCustomModelNav(View view){
        Intent intent = new Intent(this, CustomModelNavHelperActivity.class);
        startActivity(intent);
    }

    public void onGotoObjectDetection(View view){
        Intent intent = new Intent(this, ObjectDetectionActivity.class);
        startActivity(intent);
    }

    public void onGotoHelpGuide(View view){
        Intent intent = new Intent(this, HelpGuideActivity.class);
        startActivity(intent);
    }



}