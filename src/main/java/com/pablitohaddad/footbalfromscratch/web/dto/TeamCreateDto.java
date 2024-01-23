package com.pablitohaddad.footbalfromscratch.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TeamCreateDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    private Integer age;
    @NotEmpty
    private String country;
    @NotEmpty
    private String city;
    private Integer quantityTrophies;

}
