package com.org.demo.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {

    final String CREATE_SQL = "CREATE TABLE test(_id INTEGER PRIMARY KEY AUTOINCREMENT,name)";

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, null, 1);
        Log.e("a"," new DBOpenHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("a","DBOpenHelper onCreate");
        db.execSQL(CREATE_SQL);
        Log.e("a","创建数据库");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
