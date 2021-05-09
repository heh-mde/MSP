package ua.kpi.compys.iv8108.lab4;


import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.NoSuchElementException;
import java.util.Scanner;

import ua.kpi.compys.iv8108.R;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Movie");

        Movie currMovie = getMovieFullInfo();

        TextView tw = findViewById(R.id.movie_info);
        tw.setText(Html.fromHtml(currMovie.getInfo()));

        ImageView imageView = findViewById(R.id.movie_poster);
        imageView.setImageResource(currMovie.getPosterID());
    }

    private Movie getMovieFullInfo(){

        int fileID = getIntent().getExtras().getInt("file");
        Scanner scanner = new Scanner(getResources().openRawResource(fileID));
        try {
            String data = scanner.nextLine();
            JSONObject jsonObject = new JSONObject(data);

            String title = jsonObject.getString("Title");
            String year = jsonObject.getString("Year");
            String rated = jsonObject.getString("Rated");
            String released = jsonObject.getString("Released");
            String runtime = jsonObject.getString("Runtime");
            String genre = jsonObject.getString("Genre");
            String director = jsonObject.getString("Director");
            String actors = jsonObject.getString("Actors");
            String plot = jsonObject.getString("Plot");
            String language = jsonObject.getString("Language");
            String country = jsonObject.getString("Country");
            String awards = jsonObject.getString("Awards");
            String type = jsonObject.getString("Type");
            String imdbRating = jsonObject.getString("imdbRating");
            String imdbVotes = jsonObject.getString("imdbVotes");
            String imdbID = jsonObject.getString("imdbID");
            String production = jsonObject.getString("Production");
            String poster = jsonObject.getString("Poster").toLowerCase();


            int formatIndex = poster.lastIndexOf(".");
            if(formatIndex == -1)
                formatIndex = 0;
            String img = poster.substring(0, formatIndex);

            int imageID = getResources().getIdentifier(img, "drawable", getPackageName());
            Movie currMovie = new Movie(title, year, imdbID, type, imageID);
            currMovie.setInfo(rated, released, runtime, genre, director, actors, plot, language, country, awards, imdbRating, imdbVotes, production);
            return currMovie;

        } catch (JSONException e) {
            Toast.makeText(this, "JSON exception!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (NoSuchElementException e){
            Toast.makeText(this, "Exception while scanning file!", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
