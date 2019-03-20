package com.example.todo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JavaConnect extends SQLiteOpenHelper {
    public JavaConnect(  Context context   ) {
        super(context, "todo.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table user (id integer primary key autoincrement, fullname text, email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }

    //insert data in table student
    public boolean addUser(String fullname, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fullname", fullname);
        cv.put("email", email);
        cv.put("password",password);

        long result = db.insert("user", null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }//add student

    //Retrieving all values from the database
    public Cursor viewAllUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user", null);
        return  cursor;
    }

    //checking if mail exist
    public Boolean checkMail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email = ?", new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //login
    public Boolean loginUser(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email = ? and password = ?", new String[]{email,password});
        if(cursor.getCount() > 0 )
            return true;
        else
            return false;

    }

    //insert data in table student
    public boolean updateUser(String id, String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fullname", fullname);
        cv.put("email", email);
        cv.put("password", password);

        long result = db.update("user",  cv, "id="+ id,null);
        //long result = db.update("user", cv , "id=?",new String[] {id});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }//update user

    //delete user in table user
    public boolean deleteUser(String id,String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();


        long result = db.delete("user", "id = ?", new String[]{id});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }//delete user
}
