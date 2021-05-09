package ua.kpi.compys.iv8108.lab3;

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
    private final ArrayList<Movie> movies;

    public MoviesAdapter(ArrayList<Movie> moviesList) {
        movies = moviesList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView title, year, type;
        public final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            year = itemView.findViewById(R.id.movie_year);
            type = itemView.findViewById(R.id.movie_type);
            imageView = itemView.findViewById(R.id.movie_poster);
        }
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View library = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(library);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        TextView title = holder.title;
        TextView year = holder.year;
        TextView type = holder.type;
        ImageView imageView = holder.imageView;

        title.setText(movie.getTitle());
        year.setText(movie.getYear());
        type.setText(movie.getType());
        imageView.setImageResource(movie.getPosterID());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
