package com.pablitohaddad.footbalfromscratch.team.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TeamResponseDto {

    private Long id;
    private String name;
    private String surname;
    private Integer quantityTrophies;
    private Integer age;

}
