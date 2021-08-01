package com.example.myapplication;


import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

public class ArticleReportLoader extends AsyncTaskLoader<List<Article>> {
    private final String mUrl;

    public ArticleReportLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        return ArticleUtils.fetchArticleData(mUrl);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
