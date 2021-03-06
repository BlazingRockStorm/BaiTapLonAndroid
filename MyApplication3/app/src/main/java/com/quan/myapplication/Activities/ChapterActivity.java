package com.quan.myapplication.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.Entities.Chapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    private BookManager bookManager;
    private ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        init();
    }

    private void init()
    {
        try {
            bookManager = new BookManager(ChapterActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.share_pref),Context.MODE_PRIVATE);
        int bookID = sharedPref.getInt(getString(R.string.book_id), 0);
        Book book = bookManager.getBookByID(bookID);

        //Set book name
        setTitle(book.getBookName());
        TextView bookName = (TextView) findViewById(R.id.detailBookName);
        bookName.setText(book.getBookName());
        //Set book image
        ImageView imageView = (ImageView) findViewById(R.id.detailBookImg);
        int drawID = getResources().getIdentifier(book.getImagePath(),"drawable",getPackageName());
        imageView.setImageResource(drawID);

        final ArrayList<Chapter> lstChapters = bookManager.getAllChapter(bookID);
        ArrayAdapter<Chapter> chapterArrayAdapter = new ArrayAdapter<Chapter>(ChapterActivity.this,android.R.layout.simple_list_item_1, lstChapters);
        mList = (ListView) findViewById(R.id.lstChapter);
        mList.setAdapter(chapterArrayAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter chapter = lstChapters.get(position);
                Intent intent = new Intent(ChapterActivity.this,ChapterDetailActivity.class);
                intent.putExtra("chapter", chapter);
                startActivity(intent);
            }
        });
    }
}
