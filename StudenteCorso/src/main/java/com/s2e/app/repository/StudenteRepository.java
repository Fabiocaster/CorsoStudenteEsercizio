package com.s2e.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.app.model.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer>{
	
	public Studente findById(int id);

}
