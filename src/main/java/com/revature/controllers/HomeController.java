package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Home;
import com.revature.services.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {

	private HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		super();
		this.homeService = homeService;
	}

	@GetMapping
	public ResponseEntity<List<Home>> getHomes() {
		List<Home> homes = homeService.getAllHomes();
		return ResponseEntity.status(200).body(homes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Home> getHome(@PathVariable int id) {
		Home home = homeService.getHomeById(id);
		if (home != null) {
			return ResponseEntity.status(HttpStatus.OK).body(home);
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Home> getHomeByName(@PathVariable String name) {
		Home home = homeService.getHomeByName(name);
		if (home != null) {
			return ResponseEntity.status(HttpStatus.OK).body(home);
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping
	public ResponseEntity<Home> addHome(@RequestBody Home home) {
		Home dbHome = homeService.addOrUpdate(home);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbHome);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Home> updateHome(@RequestBody Home home, @PathVariable int id) {
		home.setId(id);
		Home dbHome = homeService.addOrUpdate(home);
		return ResponseEntity.status(HttpStatus.OK).body(dbHome);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Home> deleteHome(@PathVariable int id) {
		homeService.destroyHome(id);
		return ResponseEntity.status(200).build();
	}

}
