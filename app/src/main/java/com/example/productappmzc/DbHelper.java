package com.example.productappmzc;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper  {
    static String DbName="product.db";
    static String TableName="products";
    static String col1="id";
    static String col2="productcode";
    static String col3="productname";
    static String col4="price";
    public DbHelper( Context context) {
        super(context,DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TableName+
                "("+col1+" integer primary key autoincrement,"+
                col2 +" text,"+
                col3 +" text,"+
                col4 +" text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean insertdata (String productcode,String productname,String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,productcode);
        content.put(col2,productname);
        content.put(col2,price);
        long status=db.insert(TableName,null,content);
        if (status==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }



}
