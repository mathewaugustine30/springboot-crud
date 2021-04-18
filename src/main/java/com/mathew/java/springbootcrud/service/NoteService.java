package com.mathew.java.springbootcrud.service;

import com.mathew.java.springbootcrud.model.Note;

import java.util.List;


public interface NoteService {
    Note getNote(Long noteId);

    List<Note> getNotes();

    Note createNote(Note note);

    Note updateNote(Long noteId,Note note);

    void deleteNote(Long noteId);


}
