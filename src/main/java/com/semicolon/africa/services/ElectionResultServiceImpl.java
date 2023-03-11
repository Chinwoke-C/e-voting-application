package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Candidate;
import com.semicolon.africa.data.model.Election;
import com.semicolon.africa.data.model.ElectionResult;
import com.semicolon.africa.data.model.Vote;
import com.semicolon.africa.data.repositories.CandidateRepository;
import com.semicolon.africa.data.repositories.ElectionRepository;
import com.semicolon.africa.data.repositories.ElectionResultRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ElectionResultServiceImpl implements ElectionResultService{
    private final ElectionResultRepository resultRepository;
    private final ElectionRepository electionRepository;
    private final CandidateRepository candidateRepository;



    @Override
    public List<ElectionResult> getElectionResults(Long electionId) {
        return resultRepository.findByElectionId(electionId);
    }

    @Override
    public void calculateElectionResults(Long electionId) {
        Election election = electionRepository.findById(electionId)
                .orElseThrow(()-> new EntityNotFoundException("Election not found"));
        List<Vote> votes = election.getVotes();

        Map<Candidate, Integer> voteCounts = new HashMap<>();
        for(Vote vote : votes){
            Candidate candidate = vote.getCandidate();
            if(voteCounts.containsKey(candidate)){
                int count = voteCounts.get(candidate) + 1;
                voteCounts.put(candidate,count);
            }else{
                voteCounts.put(candidate, 1);
            }
        }
        for (Candidate candidate : voteCounts.keySet()){
            int voteCount = voteCounts.get(candidate);
            ElectionResult result = new ElectionResult(election, candidate, voteCount);
            resultRepository.save(result);
        }


    }

    @Override
    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }
}
