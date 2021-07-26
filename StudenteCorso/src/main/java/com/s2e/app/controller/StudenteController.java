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
import com.s2e.app.model.Studente;
import com.s2e.app.repository.CorsoRepository;
import com.s2e.app.repository.StudenteRepository;

@RestController
public class StudenteController {
	
	@Autowired
	StudenteRepository repo;
	@Autowired
	CorsoRepository repoCorsi;
	
	@GetMapping("/students")
	public Collection<Studente> getAllStudente(){
		return repo.findAll();
	}
	@PostMapping("/students")
	public void saveStudente(@RequestBody Studente studente){
		repo.save(studente);
	}
	@GetMapping("students/{studente_id}")
	public Studente getStudente(@PathVariable("studente_id") int id) {
		return repo.findById(id);
	}
	@DeleteMapping("students/{studente_id}")
	public void deleteStudente(@PathVariable("studente_id") int id) {
		
		repo.getById(id).getCorso().clear();
		for (Corso c : repoCorsi.findAll())
			c.unsubscribeStudente(repo.getById(id));
		repo.deleteById(id);
	}
	@PutMapping("students/{studente_id}")
	public void updateStudente(@PathVariable("studente_id") int id) {
		Studente student = repo.getById(id);
		student.setAttributes(student);
		repo.save(student);
	}
	

}
