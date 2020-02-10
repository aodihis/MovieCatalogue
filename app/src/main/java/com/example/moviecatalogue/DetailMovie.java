package com.example.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {

    public static final String MOVIE_DETAIL = "movie_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        TextView nameMovie = findViewById(R.id.tv_nameMovie);
        ImageView poster = findViewById(R.id.image_poster);
        TextView overview = findViewById(R.id.tv_overview);

        Movie movie = getIntent().getParcelableExtra(MOVIE_DETAIL);

        this.setTitle(movie.getName());

        nameMovie.setText(movie.getName().toUpperCase());
        poster.setImageResource(movie.getPoster());
        overview.setText(movie.getOverview());

    }
}
