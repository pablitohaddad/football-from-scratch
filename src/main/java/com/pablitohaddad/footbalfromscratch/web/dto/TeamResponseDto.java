package com.pablitohaddad.footbalfromscratch.web.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TeamResponseDto {

    private Long id;
    private String name;
    private String surname;
    private Integer quantityTrophies;

}
