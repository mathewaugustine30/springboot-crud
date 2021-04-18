package com.mathew.java.springbootcrud.repository;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
