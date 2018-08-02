package com.example.android.news;

import android.content.Context;
import android.text.TextUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, @NonNull List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        News currentNews = getItem(position);
        TextView head = (TextView) listItemView.findViewById(R.id.text1);
        assert currentNews != null;
        head.setText(currentNews.getNewsHeadline());
        TextView detail = (TextView) listItemView.findViewById(R.id.text2);
        String details;
        if(TextUtils.isEmpty(currentNews.getAuthor())) {
            detail.setText(currentNews.getSectionName());
        }
            else{
            details=(currentNews.getSectionName()+" by "+currentNews.getAuthor());
            detail.setText(details);
        }

        TextView date =(TextView) listItemView.findViewById(R.id.text3);
        String[] dates = currentNews.getDate().split("T");
        date.setText(dates[0]);

        return listItemView;
    }
}
