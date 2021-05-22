package ua.kpi.compys.iv8108.lab4;

public class Movie {
    private final String title;
    private final String year;
    private final String imdbID;
    private final String type;
    private final int poster;

    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String imdbRating;
    private String imdbVotes;
    private String production;

    public Movie(String title, String year, String imdbID, String type, int poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public void setInfo(String rated, String released, String runtime, String genre, String director,
                        String actors, String plot, String language, String country, String awards,
                        String imdbRating, String imdbVotes, String production) {
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.production = production;
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

    public int getPosterID() { return poster; }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() { return actors; }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getProduction() {
        return production;
    }

    public String getInfo() {
        return "<font color=#888888>Title: </font> " + title + "<br> " +
                "<font color=#888888>Year: </font> " + year + "<br> " +
                "<font color=#888888>Genre: </font> " + genre + "<br> " +
                "<font color=#888888>Rated: </font>" + rated + "<br><br>" +
                "<font color=#888888>Director: </font> " + director + "<br> " +
                "<font color=#888888>Actors: </font> " + actors + "<br><br>" +
                "<font color=#888888>Country: </font> " + country + "<br> " +
                "<font color=#888888>Language: </font> " + language + "<br> " +
                "<font color=#888888>Production: </font> " + production + "<br>" +
                "<font color=#888888>Released: </font>" + released + "<br>" +
                "<font color=#888888>Runtime: </font> " + runtime + "<br><br>" +
                "<font color=#888888>Awards: </font> " + awards + "<br> " +
                "<font color=#888888>ImdbRating: </font> " + imdbRating + "/10" + "<br>" +
                "<font color=#888888>ImdbVotes: </font> " + imdbVotes + "<br><br>" +
                "<font color=#888888>Plot: </font> " + plot + "<br>";
    }
}