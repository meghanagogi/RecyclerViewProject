package com.example.recyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListItemActivity extends AppCompatActivity {

    private MovieApiService retrofitService = MovieApiUtils.createService();
    private RecyclerView recyclerListView;
    private MainAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        recyclerListView = findViewById(R.id.recycler_view);
        recyclerListView.setHasFixedSize(true);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        madapter = new MainAdapter(null);
        recyclerListView.setAdapter(madapter);

        //to use the service just call one of the interface functions like shown here
        retrofitService.queryPopularMovie(MovieApiUtils.API_KEY).enqueue(new Callback<PopularMovieReturnObject>() {
            @Override
            public void onResponse(Call<PopularMovieReturnObject> call, Response<PopularMovieReturnObject> response) {
                List<Movie> movies = response.body().getMovies();
                madapter.swapLists(response.body().getMovies());
            }

            @Override
            public void onFailure(Call<PopularMovieReturnObject> call, Throwable t) {
                Log.e("API_FAILURE", "onFailure: ", t);
                Toast.makeText(ListItemActivity.this, "Error in Api, Please try again!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
