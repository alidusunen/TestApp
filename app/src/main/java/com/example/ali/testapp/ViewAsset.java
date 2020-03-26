package com.example.ali.testapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ViewAsset extends AppCompatActivity {

    public static final String colID = "com.example.ali.testapp.colID";

    DatabaseHelper assetsDb;
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_asset);
        listView = (ListView) findViewById(R.id.assetView);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        assetsDb = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = assetsDb.getReadableDatabase();
        cursor = assetsDb.getListContents(sqLiteDatabase);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String columnID = String.valueOf(i);
                Intent intent = new Intent(getApplicationContext(), DetailView.class);
                intent.putExtra(colID, columnID);
                startActivity(intent);
            }
        });

        if(cursor.moveToFirst())
        {
            do{
                String tag, category, user;
                tag = cursor.getString(0);
                category = cursor.getString(1);
                user = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(tag,category,user);
                listDataAdapter.add(dataProvider);




            }while(cursor.moveToNext());
        }
    }
    //public void openDetailView(){


    //}
}
