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

import com.revature.models.Avenger;
import com.revature.services.AvengerService;

@RestController
@RequestMapping("/avenger")
public class AvengerController {
	
	private AvengerService avengerService;

	@Autowired
	public AvengerController(AvengerService avengerService) {
		super();
		this.avengerService = avengerService;
	}

	@GetMapping
	public ResponseEntity<List<Avenger>> getAvengers() {
		List<Avenger> avengers = avengerService.getAllAvengers();
		return ResponseEntity.status(200).body(avengers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Avenger> getAvenger(@PathVariable int id) {
		Avenger avenger = avengerService.getAvengerById(id);
		if (avenger != null) {
			return ResponseEntity.status(HttpStatus.OK).body(avenger);
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping
	public ResponseEntity<Avenger> addAvenger(@RequestBody Avenger avenger) {
		Avenger dbAvenger = avengerService.addOrUpdate(avenger);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbAvenger);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger avenger, @PathVariable int id) {
		avenger.setId(id);
		Avenger dbAvenger = avengerService.addOrUpdate(avenger);
		return ResponseEntity.status(HttpStatus.OK).body(dbAvenger);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Avenger> deleteAvenger(@PathVariable int id) {
		avengerService.destroyAvenger(id);
		return ResponseEntity.status(200).build();
	}

}
