package com.example.ali.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button buttonAdd, buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddAsset();
            }
        });
        buttonView = (Button) findViewById(R.id.buttonView);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewAsset();
            }
        });

    }
    public void openAddAsset(){
        Intent intent = new Intent(this, AddAsset.class);
        startActivity(intent);
    }

    public void openViewAsset(){
        Intent intent = new Intent(this, ViewAsset.class);
        startActivity(intent);
    }

}
