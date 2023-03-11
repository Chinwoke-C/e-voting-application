package com.semicolon.africa.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partyId;

    private String name;
    //private String abbreviation;
    @OneToMany
    @JsonIgnore
    private List<Candidate> candidates;
//    @ManyToOne
//    private Election election;
    public Party(String name){
        this.name = name;
    }
//    public Election getElection(){
//        return election;
//    }

}
