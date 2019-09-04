package com.example.eco_hotel;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static final String DATABASE_NAME = "hotel.db";

    public static final String Table = "user";
    public static final String COL_1 = "email";
    public static final String COL_2 = "password";


    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table+"(email text primary key, password text)");
//        db.execSQL("drop table if EXISTS "+ Table);
//        onCreate(db);
    }

    public Boolean insert(String email, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);

        long ins = db.insert("user", null, contentValues);

        if(ins == -1){
            return false;
        }
        else {
            return  true;
        }
    }

    public  Boolean chkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email = ?", new String[] {email});

        if(cursor.getCount() > 0) return  false;
        else return true;
    }

    public  Boolean chkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email = ? and password = ?", new String[] {email, password});

        if(cursor.getCount() > 0) return  true;
        else return false;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS "+ Table);
        onCreate(db);
    }

}
