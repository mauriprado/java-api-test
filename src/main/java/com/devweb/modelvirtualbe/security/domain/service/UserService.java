package com.devweb.modelvirtualbe.security.domain.service;

import com.devweb.modelvirtualbe.security.domain.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User getEmail(String email);
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User update(Long id, User user);
}
