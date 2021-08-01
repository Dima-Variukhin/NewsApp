package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        type.setText(currentArticle.getType());

        TextView text = listView.findViewById(R.id.text);
        text.setText(currentArticle.getText());

        Date date = new Date(currentArticle.getDate());

        TextView day = listView.findViewById(R.id.date);
        String formattedDay = formatDate(date);
        day.setText(formattedDay);

        TextView time = listView.findViewById(R.id.time);
        String formattedTime = formatTime(date);
        time.setText(formattedTime);

        return listView;
    }

    private String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return simpleDateFormat.format(date);
    }

    private String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(date);
    }
}
