package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    Voter findByVoterId(String voterId);
}
