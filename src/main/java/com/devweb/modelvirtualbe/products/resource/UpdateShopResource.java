package com.devweb.modelvirtualbe.products.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateShopResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String name;

    private String logoUrl;
}
