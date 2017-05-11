package com.quan.myapplication.Activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quan.myapplication.Adapters.BookAdapter;
import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class BookActivity extends AppCompatActivity {
    private ListView lstBooks;
    private BookManager bookManager;
    private BookAdapter bookAdapter;
    private EditText searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            bookManager = new BookManager(BookActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        initLstBook(bookManager.getAllBook());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.menu_search);

        searchBox = (EditText) actionBar.getCustomView().findViewById(
                R.id.searchfield);
        // Cài đặt chế độ hiển thị
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                | ActionBar.DISPLAY_SHOW_HOME);


        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                bookAdapter.getFilter().filter(s);
            }
        });

        ImageButton imgVoiceSearch = (ImageButton) actionBar.getCustomView().findViewById(R.id.search_voice_btn);

        imgVoiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnToOpenMic();
            }
        });
    }

    private void initLstBook(ArrayList<Book> lstBook) {
        lstBooks = (ListView) findViewById(R.id.lstBook);
        bookAdapter = new BookAdapter(BookActivity.this, R.layout.book_row, lstBook);

        lstBooks.setAdapter(bookAdapter);
        lstBooks.setTextFilterEnabled(true);

        lstBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = (Book) bookAdapter.getItem(position);
                Intent intent = new Intent(BookActivity.this, ChapterActivity.class);
                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.share_pref),Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(getString(R.string.book_id), book.getBookID());
                editor.commit();
                startActivity(intent);
            }
        });
    }

    public void btnToOpenMic() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hãy nói tên truyện");

        try {
            startActivityForResult(intent, 143);
        } catch (ActivityNotFoundException tim) {

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 143:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchBox.setText(voiceInText.get(0));
                }
                break;
        }
    }

}
