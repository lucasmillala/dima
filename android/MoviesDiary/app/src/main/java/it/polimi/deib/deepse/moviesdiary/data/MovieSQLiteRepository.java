package it.polimi.deib.deepse.moviesdiary.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import it.polimi.deib.deepse.moviesdiary.model.Movie;

import static it.polimi.deib.deepse.moviesdiary.data.MovieDBContract.*;

public class MovieSQLiteRepository {

    private SQLiteDatabase db;

    public MovieSQLiteRepository(Context context){
        db = getWritableDatabase(context);
    }

    public void add(Movie movie){
        db.execSQL("INSERT OR REPLACE INTO "+MovieEntry.TABLE_NAME
        +" ("+MovieEntry._ID+","+MovieEntry.USER_RATING_CLMN+","
                +MovieEntry.USER_REVIEW_CLMN+") VALUES(?,?,?)",
                new Object[]{movie.getImdbId(), movie.getUserRating(),
                        movie.getUserReview()});
    }

    public void delete(Movie movie){

    }


}
