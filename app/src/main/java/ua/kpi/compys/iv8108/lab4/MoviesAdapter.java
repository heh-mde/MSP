package ua.kpi.compys.iv8108.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.kpi.compys.iv8108.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>  {
    private ArrayList<Movie> movies;
    private final OnMovieListener onMovieListener;

    public MoviesAdapter(ArrayList<Movie> movieList, OnMovieListener onClick) {
        movies = movieList;
        onMovieListener = onClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView title, subtitle, price;
        public final ImageView imageView;
        public final OnMovieListener onMovieListener;

        public ViewHolder(View itemView, OnMovieListener onMovieListener) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            subtitle = itemView.findViewById(R.id.movie_year);
            price = itemView.findViewById(R.id.movie_type);
            imageView = itemView.findViewById(R.id.movie_poster);
            this.onMovieListener = onMovieListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            onMovieListener.onMovieClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View library = inflater.inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(library, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.title.setText(movie.getTitle());

        holder.subtitle.setText(movie.getYear());

        holder.price.setText(movie.getType());

        holder.imageView.setImageResource(movie.getPosterID());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface OnMovieListener {
        void onMovieClick(int position);
    }


    public void changeList(ArrayList<Movie> filterlist) {

        movies = filterlist;
        notifyDataSetChanged();
    }
}