package com.app.rest_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.rest_api.moedl.Journal;
import com.app.rest_api.repo.JournalRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JournalService {

	private final JournalRepo journalRepo;

	public Journal save(Journal journal) {
		return journalRepo.save(journal);
	}

	public List<Journal> findAll() {
		return journalRepo.findAll();
	}

	public Journal findById(Long id) {
		return journalRepo.findById(id).orElseThrow();
	}

	public void deleteById(Long id) {
		journalRepo.deleteById(id);
	}

	public void updateById(Long id, Journal journal) {
		journalRepo.updateById(id, journal);
	}

	
	
	
}
