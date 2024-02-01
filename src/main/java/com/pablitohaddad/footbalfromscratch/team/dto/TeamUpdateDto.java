package com.pablitohaddad.footbalfromscratch.team.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamUpdateDto {

    @Size(min=1, message="Name must not be blank")
    private String name;
    @Positive( message="Age must not be blank")
    private Integer age;
    private Integer quantityTrophies;
}
