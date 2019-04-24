package com.example.recyclerviewproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<Movie> movies;

    public MainAdapter(List<Movie> movieList) {
        movies = movieList;
    }

    public class MainAdapterViewHolder extends RecyclerView.ViewHolder {

        public final TextView recyclerView;
        public MainAdapterViewHolder(View itemView) {
            super(itemView);
            recyclerView = (TextView) itemView.findViewById(R.id.recycler_view);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.activity_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachedToParent = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, attachedToParent);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Movie movie = movies.get(i);
        viewHolder.movieOverview.setText(movie.getOverview());
        viewHolder.movieReleaseDate.setText(movie.getReleaseDate());
        viewHolder.movieOriginalTitle.setText(movie.getOriginalTitle());
        viewHolder.movieOriginalLanguage.setText(movie.getOriginalLanguage());
        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.moviePopularity.setText(movie.getPopularity().toString());
        viewHolder.movieVoteAverage.setText(movie.getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        if (null == movies) return 0;
        return movies.size();
    }

    public void swapLists(List<Movie> newList){
        movies = newList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieOverview;
        TextView movieReleaseDate;
        TextView movieOriginalTitle;
        TextView movieOriginalLanguage;
        TextView movieTitle;
        TextView moviePopularity;
        TextView movieVoteAverage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieOverview = itemView.findViewById(R.id.movie_overview);
            movieReleaseDate = itemView.findViewById(R.id.movie_release_date);
            movieOriginalTitle = itemView.findViewById(R.id.movie_original_title);
            movieOriginalLanguage = itemView.findViewById(R.id.movie_original_language);
            movieTitle = itemView.findViewById(R.id.movie_title);
            moviePopularity = itemView.findViewById(R.id.movie_popularity);
            movieVoteAverage = itemView.findViewById(R.id.movie_vote_average);
        }
    }

}
