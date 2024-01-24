package com.pablitohaddad.footbalfromscratch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "surname", nullable = false)
    @NotEmpty
    private String surname;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "country", nullable = false)
    @NotEmpty
    private String country;

    @Column(name = "city", nullable = false)
    @NotEmpty
    private String city;

    @Column(name = "quantity trophies", nullable = true)
    private Integer quantityTrophies;

}
