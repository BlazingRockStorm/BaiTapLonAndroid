package com.quan.myapplication.Activities;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.quan.myapplication.Utils.Rule;
import com.quan.myapplication.Entities.Chapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import java.io.IOException;
import java.util.StringTokenizer;

public class ChapterDetailActivity extends AppCompatActivity {
    private BookManager bookManager;
    private TextView textView;
    private TextView countMisspellings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);
        try {
            bookManager = new BookManager(ChapterDetailActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Chapter chapter = (Chapter) getIntent().getSerializableExtra("chapter");
        setTitle(chapter.getChapterName());

        chapter = bookManager.getChapter(chapter.getChapterID());

        LoadingTextTask task = new LoadingTextTask();
        task.execute(chapter.getChapterContent().replaceAll("<", " <").replaceAll(">", "> "));

        countMisspellings = (TextView) findViewById(R.id.countMisspellings);
        textView = (TextView) findViewById(R.id.detailChapter);

    }

    private class LoadingTextTask extends AsyncTask<String, Void, Spanned> {

        private int count;

        @Override
        protected Spanned doInBackground(String... params) {
            Rule rule = new Rule();
            StringBuilder result = new StringBuilder("");
            StringTokenizer scanner = new StringTokenizer(params[0]);
            count = 0;
            // read word by word
            while (scanner.hasMoreTokens()) {
                String word = scanner.nextToken();

                if (word.contains("<") || word.contains(">")) {
                    result.append(word);
                    continue;
                } else if (rule.checkValid(word) == false) {
                    word = "<font color=#cc0029>" + word + "</font>";
                    count++;
                }
                result.append(word + " ");
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return Html.fromHtml(result.toString(), Html.FROM_HTML_MODE_COMPACT);
            } else {
                return Html.fromHtml(result.toString());
            }
        }

        @Override
        protected void onPostExecute(Spanned result) {
            textView.setText(result);
            countMisspellings.setText("Có tổng cộng " + count + " lỗi từ vựng trong chương này");
            findViewById(R.id.detailWrapper).setVisibility(View.VISIBLE);
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        }
    }
}
