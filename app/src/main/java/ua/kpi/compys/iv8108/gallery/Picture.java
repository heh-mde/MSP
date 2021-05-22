package ua.kpi.compys.iv8108.gallery;

import android.net.Uri;

public class Picture {
    private final Uri uri;
    private final String link;

    public Picture(Uri uri){
        this.uri = uri;
        link = null;
    }

    public Picture(String url){
        this.link = url;
        uri = null;
    }

    public String getLink() {
        return link;
    }

    public Uri getUri() {
        return uri;
    }
}
