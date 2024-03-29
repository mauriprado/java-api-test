package com.devweb.modelvirtualbe.security.domain.persistence;

import com.devweb.modelvirtualbe.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
    Optional<User> findById(Long id);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    
}
