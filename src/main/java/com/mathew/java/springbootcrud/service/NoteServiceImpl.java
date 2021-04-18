package com.mathew.java.springbootcrud.service;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.repository.NoteRepository;
import com.mathew.java.springbootcrud.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note getNote(Long noteId) {
        return checkIfNoteExists(noteId);
    }

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long noteId, Note note) {
        checkIfNoteExists(noteId);
        note.setId(noteId);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
        checkIfNoteExists(noteId);
        noteRepository.deleteById(noteId);
    }

    private Note checkIfNoteExists(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "noteId", noteId.toString()));
    }
}
