package com.example.orewatestodesuga;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.orewatestodesuga.MainActivity.Movielist;

public class Adapter extends BaseAdapter{

    Context context;
    String[] Movie;
    int logos[];
    LayoutInflater inflter;
    public Adapter(Context applicationContext, String[] movielist, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        this.Movie=movielist;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return logos.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_movie_list, null);
        ImageView icon =  view.findViewById(R.id.imgmovi);
        TextView Movie = view.findViewById(R.id.textmovi);
        Movie.setText(Movielist[i]);
        icon.setImageResource(logos[i]);

        return view;
    }
}