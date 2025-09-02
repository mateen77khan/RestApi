package com.app.rest_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.rest_api.model.Journal;

import jakarta.transaction.Transactional;

public interface JournalRepo extends JpaRepository<Journal, Long>{

	@Modifying
	@Transactional
	@Query("UPDATE Journal j SET j.title= :#{#journal.title}, j.content= :#{#journal.content} where j.id= :id")
	void updateById(@Param("id") Long id,@Param("journal") Journal journal);
	
	
	
}
