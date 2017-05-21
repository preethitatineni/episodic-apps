package com.example.episodicshows;

import com.example.episodicshows.shows.Show;
import com.example.episodicshows.shows.ShowRepository;
import com.example.episodicshows.user.User;
import com.example.episodicshows.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EpisodicShowsTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	UserRepository repository;

	@Autowired
	ShowRepository showRepository;

	@Test
	@Transactional
	@Rollback
	public void testGetUser() throws Exception {
		User user = new User();
		user.setEmail("test@test.com");
		User savedUser = repository.save(user);

		this.mvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].email").value("test@test.com"))
				.andExpect(jsonPath("$[0].id").value(savedUser.getId()));
	}

	@Test
	@Transactional
	@Rollback
	public void testGetShow() throws Exception {
		Show show = new Show();
		show.setName("TestShow");
		Show savedUser = showRepository.save(show);

		this.mvc.perform(get("/shows").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("TestShow"))
				.andExpect(jsonPath("$[0].id").value(savedUser.getId()));
	}
}

//.andExpect(content().contentType(MediaType.APPLICATION_JSON))