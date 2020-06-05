package com.song.reviewlitepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.song.reviewlitepal.database.MySqlLiteHelper;
import com.song.reviewlitepal.litepal.Comment;
import com.song.reviewlitepal.litepal.Songs;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Comment comment1;
    private MySqlLiteHelper sqlLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlLiteHelper = new MySqlLiteHelper(this,"demo.db",null,3);
        SQLiteDatabase db = sqlLiteHelper.getWritableDatabase();
        /*ContentValues content = new ContentValues();
        content.put("title","特朗普 eat shit");
        content.put("content","This is one new.");
        content.put("publishdate",System.currentTimeMillis());
        content.put("commentcount",120);
        long id = db.insert("news",null,content);
        Log.d("News Id", "onCreate: id = "+id);*/
        SQLiteDatabase database = LitePal.getDatabase();
        /*Songs songs = new Songs();
        songs.setName("Candy");
        songs.setSinger("Kanye");
        songs.setPublishDate(new Date());
        songs.save();*/
        /*Comment comment1 = new Comment();
        comment1.setContent("好评！");
        comment1.save();
        Comment comment2 = new Comment();
        comment2.setContent("赞一个！");
        comment2.save();
        Songs songs = new Songs();
        songs.getComments().add(comment1);
        songs.getComments().add(comment2);
        songs.setName("第二首歌");
        songs.setSinger("罗志祥");
        songs.setPublishDate(new Date());
        songs.save();*/


    }

    public int SQLiteUpdate(){
        SQLiteDatabase db = sqlLiteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title","今日iPhone 6发布");
        return db.update("news",values,"id = ?",new String[]{"2"});
    }
    public int SQLiteDelete(){
        SQLiteDatabase db = sqlLiteHelper.getWritableDatabase();
        return db.delete("news","commentcount = ?",new String[]{"0"});
    }

    public int LitePalUpdate(){
        ContentValues values = new ContentValues();
        values.put("title","今日iPhone6发布");
        return LitePal.update(Songs.class,values,2);
    }

    public int LitePalUpdateAll(){
        ContentValues values = new ContentValues();
        values.put("title","今日iPhone6 plus发布");
        LitePal.updateAll(Songs.class,values,"title = ?","今日iPhone6发布");

        //===============
         values = new ContentValues();
        values.put("title","今日iPhone6 plus发布");
        LitePal.updateAll(Songs.class,values,"title = ? and commentcount > ?","今日iPhone6发布","0");
        //===============
        values = new ContentValues();
        values.put("title","今日iPhone6 plus发布");
        LitePal.updateAll(Songs.class,values);

        //===============
        Songs songs = new Songs();
        songs.setName("后来");
        songs.update(2);

        //===============
        songs = new Songs();
        songs.setName("后来");
        songs.updateAll("name = ?","晴天");

        //===============
        songs = new Songs();
        songs.setName("后来");
        return songs.updateAll();
    }



}
