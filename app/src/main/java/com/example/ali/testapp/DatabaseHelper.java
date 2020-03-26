package com.example.ali.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "assets.db";
    public static final String TABLE_ASSET = "assets_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Item";
    public static final String COL_3 = "Category";
    public static final String COL_4 = "Serial";
    public static final String COL_5 = "User";
    public static final String COL_6 = "Location";

    public static final String TABLE_USER = "users_table";
    public static final String COL_1_USER = "ID";
    public static final String COL_NAME = "Name";
    public static final String COL_POS = "Position";

    public static final String TABLE_REL = "relations_table";
    public static final String COL_1_REL = "ID";
    public static final String COL_ASSET_ID = "AssetID";
    public static final String COL_USER_ID = "UserID";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(" create table " + TABLE_ASSET + " ID INTEGER PRIMARY KEY AUTOINCREMENT, Item TEXT, Category TEXT, Serial TEXT, User TEXT, Location TEXT");

        //db.execSQL("CREATE TABLE " + TABLE_ASSET + " (" + COLUMN_FIRST_NAME + " VARCHAR," + COLUMN_TWO_NAME
        //        + " VARCHAR," + COLUMN_THREE_NAME + " DECIMAL);")

        db.execSQL("CREATE TABLE " + TABLE_ASSET + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT,"
                + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT);");

        db.execSQL("CREATE TABLE " + TABLE_USER + " (" + COL_1_USER + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " TEXT,"
                + COL_POS + " TEXT);");

        db.execSQL("CREATE TABLE " + TABLE_REL + " (" + COL_1_REL + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_USER_ID + " INTEGER,"
                + COL_ASSET_ID + " INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ASSET);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_REL);
        onCreate(db);
    }

    public boolean insertAssetData(String item, String category, String serial, String user, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL_2, item);
        contentValues.put(COL_3, category);
        contentValues.put(COL_4, serial);
        contentValues.put(COL_5, user);
        contentValues.put(COL_6, location);
        long result = db.insert(TABLE_ASSET,null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertUserData(String name, String position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_NAME, name);
        contentValues.put(COL_POS, position);

        long result = db.insert(TABLE_USER, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getListContents(SQLiteDatabase db){

            Cursor cursor;
            String[] projections = {COL_2, COL_3, COL_5};
            cursor = db.query(TABLE_ASSET, projections, null, null, null, null,null);
            return cursor;

    }
    // asagidaki kodu ben yazdım detail view icin

    public Cursor showListContents(SQLiteDatabase db) {
        Cursor cursorShow;
        String[] pro_show = {COL_2, COL_3, COL_4, COL_5, COL_6};
        cursorShow = db.query(TABLE_ASSET, pro_show, null, null, null, null, null);


        return cursorShow;
    }
}
