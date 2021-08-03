package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        Article currentArticle = getItem(position);

        TextView sectionName = listView.findViewById(R.id.sectionName);
        sectionName.setText(currentArticle.getSectionName());

        TextView type = listView.findViewById(R.id.type);
        type.setText(currentArticle.getAuthor());

        TextView text = listView.findViewById(R.id.text);
        text.setText(currentArticle.getText());

        String date = currentArticle.getDate();
        TextView day = listView.findViewById(R.id.date);
        day.setText(date);


        return listView;
    }


}
