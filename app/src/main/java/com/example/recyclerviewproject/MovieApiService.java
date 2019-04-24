package com.example.recyclerviewproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET(MovieApiUtils.POPULAR_PATH)
    Call<PopularMovieReturnObject> queryPopularMovie(@Query(MovieApiUtils.API_KEY_PARAM) String apiKey);

    @GET(MovieApiUtils.TOPRATED_PATH)
    Call<TopRatedMovieReturnObject> queryTopRatedPath(@Query(MovieApiUtils.API_KEY_PARAM) String apiKey);

}
