package ua.kpi.compys.iv8108.gallery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import ua.kpi.compys.iv8108.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>  {
    private static final ArrayList<Picture[]> pictures = new ArrayList<>();
    private static int counter = -1;
    private final int IMAGE_SIZE;

    public GalleryAdapter(int w){
        setHasStableIds(true);
        IMAGE_SIZE = w / 5;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView[] imageViews;
        public ViewHolder(View itemView) {
            super(itemView);
            imageViews = new ImageView[6];
            imageViews[0] = itemView.findViewById(R.id.gal_picture0);
            imageViews[1] = itemView.findViewById(R.id.gal_picture1);
            imageViews[2] = itemView.findViewById(R.id.gal_picture2);
            imageViews[3] = itemView.findViewById(R.id.gal_picture3);
            imageViews[4] = itemView.findViewById(R.id.gal_picture4);
            imageViews[5] = itemView.findViewById(R.id.gal_picture5);
        }
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        int size;
        ImageView currIV;
            for (int i = 0; i < 6; i++) {
                currIV = holder.imageViews[i];
                size = IMAGE_SIZE;
                if(i == 0)
                    size *= 3;
                if(i > 3)
                    size *= 2;
                currIV.getLayoutParams().width = size;
                currIV.getLayoutParams().height = size;
                currIV.setVisibility(View.INVISIBLE);

                if(pictures.get(position)[i] != null){
                    currIV.setVisibility(View.VISIBLE);

                    Uri currUri = pictures.get(position)[i].getUri();
                    if (currUri == null) {
                        Animation a = new RotateAnimation(0.0f, 360.0f,
                                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                                0.5f);
                        a.setRepeatCount(-1);
                        a.setDuration(1000);
                        Ion.with(currIV)
                                .placeholder(R.drawable.ic_spinner_pb)
                                .animateLoad(a)
                                .load(pictures.get(position)[i].getLink());
                    } else currIV.setImageURI(currUri);
                }
            }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View prevView = inflater.inflate(R.layout.item_picture, parent, false);
        return new ViewHolder(prevView);
    }

    public void addElementUri(Uri uri) {
        counter ++;
        if(counter % 6 == 0)
            pictures.add(new Picture[6]);
        pictures.get(counter / 6)[counter % 6] = new Picture(uri);
        notifyDataSetChanged();
    }

    public void addElementsURL(JSONArray elements) throws JSONException {
        for (int i = 0; i < elements.length(); i++) {
            counter ++;
            if(counter % 6 == 0)
                pictures.add(new Picture[6]);

            String currURL = elements.getJSONObject(i).getString("webformatURL");
            pictures.get(counter / 6)[counter % 6] = new Picture(currURL);

        }
        notifyDataSetChanged();
    }
}