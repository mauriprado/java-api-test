package com.devweb.modelvirtualbe.security.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
