package com.devweb.modelvirtualbe.security.api;

import com.devweb.modelvirtualbe.products.resource.CreateFavoriteResource;
import com.devweb.modelvirtualbe.security.domain.model.entity.User;
import com.devweb.modelvirtualbe.security.domain.service.UserService;
import com.devweb.modelvirtualbe.security.mapping.UserMapper;
import com.devweb.modelvirtualbe.security.resource.CreateUserResource;
import com.devweb.modelvirtualbe.security.resource.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users")
@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("{userId}")
    public UserResource getUserId(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }
    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource resource){
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }
}
