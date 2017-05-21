package com.example.episodicshows.shows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trainer6 on 5/21/17.
 */
@RestController
public class ShowsController {

    @Autowired
    ShowRepository showRepository;


    @GetMapping("/shows")
    public List<Show> getShows(){
        List<Show> shows = (List<Show>) showRepository.findAll();
        return shows;
    }

    @PostMapping("/shows")
    public Show addShow(@RequestBody Show show){
        return showRepository.save(show);
    }

}
