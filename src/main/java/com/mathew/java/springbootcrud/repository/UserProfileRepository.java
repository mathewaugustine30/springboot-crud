package com.mathew.java.springbootcrud.repository;

import com.mathew.java.springbootcrud.model.Note;
import com.mathew.java.springbootcrud.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
