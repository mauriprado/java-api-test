package com.devweb.modelvirtualbe.security.service;

import com.devweb.modelvirtualbe.security.domain.model.entity.User;
import com.devweb.modelvirtualbe.security.domain.persistence.UserRepository;
import com.devweb.modelvirtualbe.security.domain.service.UserService;
import com.devweb.modelvirtualbe.shared.exception.ResourceNotFoundException;
import com.devweb.modelvirtualbe.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";
    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public User getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        User userWithEmailAndPassword = userRepository.findByEmail(user.getEmail());
        if(userWithEmailAndPassword != null)
            throw new ResourceValidationException(ENTITY, "Email or Password incorrect");
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        User userWithEmailAndPassword = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userWithEmailAndPassword != null)
            throw new ResourceValidationException(ENTITY, "Email or Password incorrect");
        return userRepository.findById(id).map(m->
                userRepository.save(
                        m.withEmail(user.getEmail())
                                .withPassword(user.getPassword())
                                .withLastName(user.getLastName())
                                .withFirstName(user.getFirstName())
                                .withYear(user.getYear())
                                .withProfileImage(user.getProfileImage())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }
}
