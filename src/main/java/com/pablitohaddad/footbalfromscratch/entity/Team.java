package com.pablitohaddad.footbalfromscratch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotBlank()
    private String name;
    @Column(nullable = false)
    @NotBlank()
    private String country;
    @Column(nullable = false)
    @NotBlank()
    private String city;
    @NotNull
    private Integer age;
    private Integer quantityTrophies;

}
