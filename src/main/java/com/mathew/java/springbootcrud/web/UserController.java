package com.mathew.java.springbootcrud.web;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.model.User;
import com.mathew.java.springbootcrud.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/users")
    public ResponseEntity<User> add(@Valid @RequestBody User user) {
        //noteService.createNote(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}