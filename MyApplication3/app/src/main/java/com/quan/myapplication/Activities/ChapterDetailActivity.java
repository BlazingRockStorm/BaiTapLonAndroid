package com.quan.myapplication.Activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.quan.myapplication.Utils.Rule;
import com.quan.myapplication.Entities.Chapter;
import com.quan.myapplication.Managers.BookManager;
import com.quan.myapplication.R;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.StringTokenizer;

public class ChapterDetailActivity extends AppCompatActivity {
    BookManager bookManager;

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

        Rule rule = new Rule();
        StringBuilder result = new StringBuilder("");
        StringTokenizer scanner = new StringTokenizer(chapter.getChapterContent().replaceAll("<", " <").replaceAll(">", "> "));
        int count = 0;
        // read word by word
        while (scanner.hasMoreTokens()) {
            String word = scanner.nextToken();

            System.out.println(" " + word);

            if (word.contains("<") || word.contains(">")) {
                result.append(word);
                continue;
            } else if (rule.checkValid(word) == false) {
                word = "<font color=#cc0029>" + word + "</font>";
                count++;
            }
            result.append(word + " ");


        }
        TextView countMisspellings = (TextView) findViewById(R.id.countMisspellings);
        countMisspellings.setText("Có tổng cộng " + count + " lỗi từ vựng trong chương này");
        TextView textView = (TextView) findViewById(R.id.detailChapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(result.toString(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(result.toString()));
        }
    }
}
