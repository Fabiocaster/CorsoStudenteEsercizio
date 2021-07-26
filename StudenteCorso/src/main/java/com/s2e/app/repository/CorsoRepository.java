package com.s2e.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.app.model.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Integer>{
	
	public Corso findById(int id);
}
