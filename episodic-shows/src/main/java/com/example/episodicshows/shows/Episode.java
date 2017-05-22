package com.example.episodicshows.shows;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by trainer6 on 5/21/17.
 */
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue
    private Long id;


    private Long show_id;

    @JsonProperty("seasonNumber")
    private Long season_number;

    @JsonProperty("episodeNumber")
    private Long episode_number;

    public String getTitle() {
        return "S" + season_number + " " + "E" + episode_number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    @JsonProperty("title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShow_id() {
        return show_id;
    }

    public void setShow_id(Long show_id) {
        this.show_id = show_id;
    }

    public Long getSeason_number() {
        return season_number;
    }

    public void setSeason_number(Long season_number) {
        this.season_number = season_number;
    }

    public Long getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(Long episode_number) {
        this.episode_number = episode_number;
    }
}
