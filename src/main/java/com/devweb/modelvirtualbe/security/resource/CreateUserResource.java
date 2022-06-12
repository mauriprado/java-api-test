package com.devweb.modelvirtualbe.security.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResource {
    @NotNull
    @NotBlank
    @Size(max = 40)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String password;

    @NotBlank
    @NotNull
    @Size(max = 15)
    private String firstName;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String lastName;

    private int Year;

    private String profileImage;
}
