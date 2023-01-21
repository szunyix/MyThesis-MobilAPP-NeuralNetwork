package com.szunyix.mythesis.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.szunyix.mythesis.R;
import com.szunyix.mythesis.image.CustomModelActivity;

public class CustomModelNavHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_model_nav_helper);
        getSupportActionBar().hide();
    }

    public void onGotoCustomModelFlower(View view){

        Intent intent = new Intent(this, CustomModelActivity.class);
        intent.putExtra("keyName", "flower");
        startActivity(intent);
    }

    public void onGotoCustomModelLatinPlant(View view){

        Intent intent = new Intent(this, CustomModelActivity.class);
        intent.putExtra("keyName","latinPlant");
        startActivity(intent);
    }

    public void onGotoCustomModelPlant(View view){

        Intent intent = new Intent(this, CustomModelActivity.class);
        intent.putExtra("keyName","plant");
        startActivity(intent);
    }
}