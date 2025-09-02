package com.app.rest_api.controller;

import java.util.List;
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
@RequestMapping("/journal")
public class JournalController {

	private final JournalService journalService;

	@PostMapping
	public Journal save(@RequestBody Journal journal) {
		return journalService.save(journal);
	}

	@GetMapping
	public List<Journal> findAll() {
		return journalService.findAll();
	}

	@GetMapping("/id/{id}")
	public Journal findById(@PathVariable Long id) {
		return journalService.findById(id);
	}

	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id) {
		journalService.deleteById(id);
	}

	@PutMapping("/id/{id}")
	public void updateById(@PathVariable Long id,@RequestBody Journal journal) {
		journalService.updateById(id, journal);
	}
	
	

	
	
	
	
	
}
