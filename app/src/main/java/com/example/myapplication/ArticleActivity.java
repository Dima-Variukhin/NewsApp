package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity implements LoaderCallbacks<List<Article>> {
    private static final int ARTICLE_LOADER_ID = 1;
    public ArticleAdapter aAdapter;
    private TextView mEmptyStateTextView;
    private static final String REQUEST_URL = "https://content.guardianapis.com/search?q=Careers&show-tags=contributor&api-key=test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);

        ListView articleListView = findViewById(R.id.list);
        aAdapter = new ArticleAdapter(this, new ArrayList<>());
        articleListView.setAdapter(aAdapter);

        articleListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Article article = aAdapter.getItem(i);
            Uri articleURI = Uri.parse(article.getUrl());
            Intent website = new Intent(Intent.ACTION_VIEW, articleURI);
            ArticleActivity.this.startActivity(website);
        });

        mEmptyStateTextView = findViewById(R.id.empty);
        articleListView.setEmptyView(mEmptyStateTextView);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        Network network = connMgr.getActiveNetwork();
        if (network != null) {
            android.app.LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("content.guardianapis.com");
        builder.appendPath("search");
//        builder.appendQueryParameter("q", "Careers");
        builder.appendQueryParameter("show-tags", "contributor");
        builder.appendQueryParameter("api-key", "test");
        String URL = builder.build().toString();
        Uri baseUri = Uri.parse(URL).buildUpon().build();
        return new ArticleReportLoader(this, baseUri.toString());
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Article>> loader, List<Article> data) {
        View loadingIndicator = findViewById(R.id.loading_spinner);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.empty);
        aAdapter.clear();
        if (data != null && !data.isEmpty()) {
            aAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<Article>> loader) {
        aAdapter.clear();
    }
}