package com.app.rest_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.rest_api.model.Journal;
import com.app.rest_api.model.User;
import com.app.rest_api.repo.UserRepo;
import com.app.rest_api.service.JournalService;
import com.app.rest_api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/journal")
public class JournalController {

	private final JournalService journalService;
	private final UserService userService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Journal journal, @RequestParam Long userId) {
	    User user = userService.findById(userId);
	    if (user == null) {
	        return ResponseEntity.badRequest().body("User not found");
	    }
	    journal.setUser(user);
	    return ResponseEntity.ok(journalService.save(journal));
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
