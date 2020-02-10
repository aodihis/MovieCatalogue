package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.list_movie);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent DetailMoviewIntent = new Intent(MainActivity.this, DetailMovie.class);
                DetailMoviewIntent.putExtra(DetailMovie.MOVIE_DETAIL, movies.get(i));
                startActivity(DetailMoviewIntent);

//                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setOverview(dataDescription[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.movie_name);
        dataDescription =  getResources().getStringArray(R.array.movie_overview);
        dataPoster = getResources().obtainTypedArray(R.array.movie_poster);
    }
}
