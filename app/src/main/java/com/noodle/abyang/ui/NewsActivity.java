package com.noodle.abyang.ui;

import static com.noodle.abyang.core.Constants.Extra.NEWS_ITEM;
import android.os.Bundle;
import android.widget.TextView;

import com.noodle.abyang.R;
import com.noodle.abyang.core.News;

import butterknife.InjectView;

public class NewsActivity extends BootstrapActivity {

    protected News newsItem;

    @InjectView(R.id.tv_title) protected TextView title;
    @InjectView(R.id.tv_content) protected TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.news);

        if(getIntent() != null && getIntent().getExtras() != null) {
            newsItem = (News) getIntent().getExtras().getSerializable(NEWS_ITEM);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle(newsItem.getTitle());

        title.setText(newsItem.getTitle());
        content.setText(newsItem.getContent());

    }

}
