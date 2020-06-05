package com.song.reviewlitepal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlLiteHelper extends SQLiteOpenHelper {

    private static final String CREATE_NEWS = "create table news (" +
            "id integer primary key autoincrement ," +
            "title text," +
            "content text," +
            "publishdate integer," +
            "commentcount integer)";

    private static final String CREATE_COMMENT = "create table comment(" +
            "id integer primary key autoincrement," +
            "content text)";
    public MySqlLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS);
        db.execSQL(CREATE_COMMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1:
                db.execSQL(CREATE_COMMENT);
            case 2:
                db.execSQL("alter table comment add column publishdate integer");
            default:
        }
    }
}
