package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Candidate;
import com.semicolon.africa.data.model.ElectionResult;

import java.util.List;

public interface ElectionResultService {
   List<ElectionResult> getElectionResults(Long electionId);
   void calculateElectionResults(Long electionId);
    List<Candidate> getCandidatesByElection(Long electionId);

}
