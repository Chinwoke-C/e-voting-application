package com.semicolon.africa.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ElectionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;

    @ManyToOne
    private Election election;

    @ManyToOne
    private Candidate candidate;

    private int voteCount;


    public ElectionResult(Election election, Candidate candidate, int voteCount) {
        this.election = election;
        this.candidate = candidate;
        this.voteCount = voteCount;
    }
}


