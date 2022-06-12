package com.devweb.modelvirtualbe.security.mapping;

import com.devweb.modelvirtualbe.security.domain.model.entity.User;
import com.devweb.modelvirtualbe.security.resource.CreateUserResource;
import com.devweb.modelvirtualbe.security.resource.UpdateUserResource;
import com.devweb.modelvirtualbe.security.resource.UserResource;
import com.devweb.modelvirtualbe.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }
    public List<UserResource> toResourceList(List<User> modelList){
        return mapper.mapList(modelList, UserResource.class);
    }
    public User toModel(UserResource resource){
        return mapper.map(resource, User.class);
    }
    public User toModel(CreateUserResource resource){
        return mapper.map(resource, User.class);
    }
    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }
}
