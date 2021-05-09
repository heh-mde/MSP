package ua.kpi.compys.iv8108.lab3;

public class Movie {
    private final String title;
    private final String year;
    private final String imdbID;
    private final String type;
    private final int poster;

    public Movie(String title, String year, String imdbID, String type, int poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }
    public String getYear() {
        return year;
    }
    public String getType() {
        return type;
    }
    public String getImdbID() {
        return imdbID;
    }
    public int getPosterID(){
        return poster;
    }
}