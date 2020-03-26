package com.example.ali.testapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    DatabaseHelper assetsDb;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    TextView tag_view, category_view, serial_view, user_view, location_view;
    int rowNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        assetsDb = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = assetsDb.getReadableDatabase();
        cursor = assetsDb.showListContents(sqLiteDatabase);

        Intent intent = getIntent();
        String recordID = intent.getStringExtra(ViewAsset.colID);
        rowNumber = Integer.parseInt(recordID);

        cursor.move(rowNumber+1);

        tag_view = (TextView) findViewById(R.id.detail_tag);
        tag_view.setText(cursor.getString(0));

        category_view = (TextView) findViewById(R.id.detail_category);
        category_view.setText(cursor.getString(1));
        serial_view = (TextView) findViewById(R.id.detail_serial);
        serial_view.setText(cursor.getString(2));
        user_view = (TextView) findViewById(R.id.detail_user);
        user_view.setText(cursor.getString(3));
        location_view = (TextView) findViewById(R.id.detail_location);
        location_view.setText(cursor.getString(4));


    }
}
