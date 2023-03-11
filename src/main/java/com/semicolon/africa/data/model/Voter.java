package com.semicolon.africa.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voter")

public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//@JsonProperty("full_name")
    private String name;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String email;
    private String password;
    private String createdAt;
    private String voterId;

}
