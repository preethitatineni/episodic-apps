package com.example.episodicshows.shows;

import javax.persistence.*;
import java.util.List;

/**
 * Created by trainer6 on 5/21/17.
 */
@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="show_id")
    private List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
