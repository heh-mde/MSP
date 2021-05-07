package ua.kpi.compys.iv8108.lab3;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import ua.kpi.compys.iv8108.R;

public class ListViewController extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Context context = Objects.requireNonNull(getActivity()).getApplicationContext();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.movieslist));
        try {
            String data = scanner.nextLine();
            JSONObject jsonObject = new JSONObject(data);
            ArrayList<Movie> library = processingJsonObj(jsonObject);

            recyclerView.setAdapter(new MoviesAdapter(library));
        } catch (JSONException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Movie> processingJsonObj(JSONObject jsonObject) throws JSONException {
        JSONArray moviesInJSON = jsonObject.getJSONArray("Search");
        ArrayList<Movie> library = new ArrayList<>();
        for (int i = 0; i < moviesInJSON.length(); i++) {
            JSONObject c = moviesInJSON.getJSONObject(i);
            String title = c.getString("Title");
            String year = c.getString("Year");
            String imdbID = c.getString("imdbID");
            String type = c.getString("Type");
            String poster = c.getString("Poster").toLowerCase();


            int formatIndex = poster.lastIndexOf(".");
            if(formatIndex == -1)
                formatIndex = 0;
            String img = poster.substring(0, formatIndex);

            int posterID = getResources().getIdentifier(img, "drawable", getContext().getPackageName());
            library.add(new Movie(title, year, imdbID, type, posterID));
        }
        return library;

    }
}