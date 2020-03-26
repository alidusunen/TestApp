package com.example.ali.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "assets.db";
    public static final String TABLE_NAME = "assets_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Item";
    public static final String COL_3 = "Category";
    public static final String COL_4 = "Serial";
    public static final String COL_5 = "User";
    public static final String COL_6 = "Location";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(" create table " + TABLE_NAME + " ID INTEGER PRIMARY KEY AUTOINCREMENT, Item TEXT, Category TEXT, Serial TEXT, User TEXT, Location TEXT");

        //db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_FIRST_NAME + " VARCHAR," + COLUMN_TWO_NAME
        //        + " VARCHAR," + COLUMN_THREE_NAME + " DECIMAL);")

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT,"
                + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String item, String category, String serial, String user, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL_2, item);
        contentValues.put(COL_3, category);
        contentValues.put(COL_4, serial);
        contentValues.put(COL_5, user);
        contentValues.put(COL_6, location);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getListContents(SQLiteDatabase db){

            Cursor cursor;
            String[] projections = {COL_2, COL_3, COL_5};
            cursor = db.query(TABLE_NAME, projections, null, null, null, null,null);
            return cursor;

    }
    // asagidaki kodu ben yazdım detail view icin

    public Cursor showListContents(SQLiteDatabase db) {
        Cursor cursorShow;
        String[] pro_show = {COL_2, COL_3, COL_4, COL_5, COL_6};
        cursorShow = db.query(TABLE_NAME, pro_show, null, null, null, null, null);


        return cursorShow;
    }
}
