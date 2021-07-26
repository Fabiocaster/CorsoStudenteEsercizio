package com.s2e.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.repository.CorsoRepository;
import com.s2e.app.repository.StudenteRepository;

@RestController
public class CorsoStudenteController {
	
	@Autowired
	StudenteRepository repostud;
	@Autowired
	CorsoRepository repocorso;
	
	

}
