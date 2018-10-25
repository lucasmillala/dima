package it.polimi.deib.deepse.moviesdiary.rest;

import it.polimi.deib.deepse.moviesdiary.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieRESTInterface {


    @GET("/?")
    public Call<Movie> getMovie(@Query("i") String imdbId,
                                @Query("apikey") String apiKey);

}
