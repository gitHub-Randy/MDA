package com.example.pokedex;

public class FilmsModel {
    String title;
    String episode_id;
    String director;
    String producer;
    String releaseDate;
    String openingCrawl;



    public FilmsModel(String title, String episode_id, String director, String producer, String releaseDate, String openingCrawl){
        this.title = title;
        this.episode_id = episode_id;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.openingCrawl = openingCrawl;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }
}
