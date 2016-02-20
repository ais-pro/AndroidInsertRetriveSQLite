package com.example.aisuv.databaseinsertretrive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aisuv on 2/20/2016.
 */
public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context, "test1.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table one (id integer primary key autoincrement, name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists one");
        onCreate(db);
    }

    public long insert(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name", name);
        return db.insert("one",null,cv);
    }

    public Cursor Show(){
        Cursor cursor;
        SQLiteDatabase db=this.getReadableDatabase();
        cursor=db.rawQuery("select * from one",null);
        return cursor;
    }
}
