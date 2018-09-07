package service;



import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.autoconfigure.*;

import org.springframework.stereotype.*;
import model.Artist;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistService {
	private String base = "http://api.musixmatch.com/ws/1.1/";
	public String getArtistInfo(String name) {
		// TODO Auto-generated method st  ub
		final String uri = base+"artist.search?page_size=5&apikey=9ea0147d8fc3ae9d7d3a075809550eb6&q_artist="+name;
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	public String getTopAlbum(String loc) {
		final String url = base+"chart.tracks.get?page=1&page_size=5&country="+loc+"f_has_lyrics=1";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	public String getLyrics(String track, String artist) {
		URI uri;
		String result = null;
		try {
			uri = new URI(track.replace(" ", "%20"));
			final String url =  base+"matcher.lyrics.get?q_track="+uri+"&q_artist="+artist;
			RestTemplate restTemplate = new RestTemplate();
			result = restTemplate.getForObject(url, String.class);
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

