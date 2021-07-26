package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Corso;

import com.s2e.app.repository.CorsoRepository;

@RestController
public class CorsoController {
	
	@Autowired
	CorsoRepository repo;
	
	@GetMapping("/courses")
	public Collection<Corso> getAllCorso() {
		return repo.findAll();
	}

	@PostMapping("/courses")
	public void saveCorso(@RequestBody Corso corso) {
		repo.save(corso);
	}

	@GetMapping("/courses/{corso_id}")
	public Corso getCorso(@PathVariable("corso_id") int id) {
		return repo.findById(id);
	}
		
	@DeleteMapping("/courses/{corso_id}")
	public void deleteCorso(@PathVariable("corso_id") int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/courses/{corso_id}")
	public void updateCorso(@PathVariable("corso_id") int id) {
		Corso corso = repo.getById(id);
		corso.setAttributes(corso);
		repo.save(corso);
	}

}
