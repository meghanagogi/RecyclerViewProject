package com.example.recyclerviewproject;

public class MovieApiUtils {

    public static final String API_KEY = "";
    public static final String POPULAR_PATH = "popular" ;
    public static final String TOPRATED_PATH = "top_rated";
    public static final String API_KEY_PARAM = "api_key";
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public static MovieApiService createService(){
        return NetworkClientUtils.getClient(BASE_URL).create(MovieApiService.class);
    }

}
