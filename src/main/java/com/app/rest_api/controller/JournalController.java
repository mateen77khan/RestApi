package com.app.rest_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.rest_api.moedl.Journal;
import com.app.rest_api.service.JournalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://journally-ten.vercel.app/")
@RequestMapping("/journal")
public class JournalController {

	private final JournalService journalService;

//	save
	@PostMapping
	public Journal save(@RequestBody Journal journal) {
		return journalService.save(journal);
	}

//	find all
	@GetMapping
	public List<Journal> findAll() {
		return journalService.findAll();
	}

//	find by id
	@GetMapping("/id/{id}")
	public Journal findById(@PathVariable Long id) {
		return journalService.findById(id);
	}

//	delete
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id) {
		journalService.deleteById(id);
	}

//	update
	@PutMapping("/id/{id}")
	public void updateById(@PathVariable Long id,@RequestBody Journal journal) {
		journalService.updateById(id, journal);
	}
	
	

	
	
	
	
	
}
