package com.devweb.modelvirtualbe.security.resource;

import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int Year;
    private String profileImage;
}
