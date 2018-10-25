package it.polimi.deib.deepse.moviesdiary.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.polimi.deib.deepse.moviesdiary.R;
import it.polimi.deib.deepse.moviesdiary.adapter.MovieArrayAdapter;
import it.polimi.deib.deepse.moviesdiary.model.Movie;
import it.polimi.deib.deepse.moviesdiary.rest.MovieRESTInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        retriveMovies();

    }

    private void retriveMovies(){

        movies = new ArrayList<>();

        final TypedArray movieIds = getResources()
                .obtainTypedArray(R.array.movies_imdb_ids);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieRESTInterface restInterface =
                retrofit.create(MovieRESTInterface.class);

        for (int i = 0; i < movieIds.length(); i++){

            String imdbId = movieIds.getString(i);

            restInterface.getMovie(imdbId, "b8c79639")
                    .enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    Movie movie = response.body();
                    movies.add(movie);
                    if (movies.size() == movieIds.length()){
                        setupMoviesList();
                    }
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    System.out.println("ERROR!!!");
                }
            });

        }

    }

    private void setupMoviesList(){
        ListView listView = findViewById(R.id.listView1);
        ArrayAdapter<Movie> arrayAdapter =
                new MovieArrayAdapter(this, movies);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
