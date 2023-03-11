package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.model.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionResultRepository extends JpaRepository<ElectionResult, Long > {
    List<ElectionResult> findByElectionId(Long electionId);

    List<ElectionResult> findByCandidateId(Long candidateId);

}
