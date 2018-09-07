package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;

import org.springframework.stereotype.*;
import model.Artist;
import service.ArtistService; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/artist")
public class ArtistController {
	
	@Autowired
	ArtistService as;
	
	@RequestMapping("{name}")
	public String getArtistInfo(@PathVariable("name") String name) {
		return as.getArtistInfo(name);
		
	}	
	@RequestMapping("{loc}")
	public String getInfo(@PathVariable("loc") String location) {
		return as.getArtistInfo(location);
	}
	@RequestMapping("{track}/{artist}")
	public String getLyrics(@PathVariable("track") String track,@PathVariable("artist") String artist) {
		return as.getLyrics(track,artist);
	}
	

}
