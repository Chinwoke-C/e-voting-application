package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
