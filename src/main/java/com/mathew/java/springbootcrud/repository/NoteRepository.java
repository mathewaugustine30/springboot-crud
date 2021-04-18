package com.mathew.java.springbootcrud.repository;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
