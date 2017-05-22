package com.example.episodicshows.shows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainer6 on 5/21/17.
 */
@RestController
public class ShowsController {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    EpisodeRepository episodeRepository;


    @GetMapping("/shows")
    public List<Show> getShows(){
        List<Show> shows = (List<Show>) showRepository.findAll();
        return shows;
    }

    @PostMapping("/shows")
    public Show addShow(@RequestBody Show show){
        return showRepository.save(show);
    }

    @GetMapping("/shows/{id}/episodes")
    public List<Episode> getEpisodesForShow(@PathVariable Long id){
        Show show = showRepository.findOne(id);
        return show.getEpisodes();
    }

    @PostMapping("/shows/{id}/episodes")
    public ResponseEntity<Episode> saveEpisode (@PathVariable("id") Long showId, @RequestBody Episode episode){
        Show show = null;
        if(showRepository.exists(showId)){
            show = showRepository.findOne(showId);
            episode.setShow_id(showId);
            Episode savedEpisode = episodeRepository.save(episode);
            return new ResponseEntity<Episode>(savedEpisode, HttpStatus.OK);
        }else{
            return new ResponseEntity<Episode>(episode, HttpStatus.NOT_FOUND);
        }
    }

}
