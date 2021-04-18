package com.mathew.java.springbootcrud.web;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.model.Product;
import com.mathew.java.springbootcrud.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Value("${spring.message}")
    private String message;

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getProducts() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> add(@Valid @RequestBody Note note) {
        noteService.createNote(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long noteId) {
        return new ResponseEntity<>(noteService.getNote(noteId),HttpStatus.OK);
    }


    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {

        noteService.deleteNote(noteId);
        return ResponseEntity.ok().build();
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Note noteDetails) {
        return new ResponseEntity<>(noteService.updateNote(id,noteDetails), HttpStatus.OK);
    }



}
