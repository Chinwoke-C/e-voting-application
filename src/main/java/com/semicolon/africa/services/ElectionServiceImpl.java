package com.semicolon.africa.services;

import com.semicolon.africa.data.dto.Request.CandidateRequest;
import com.semicolon.africa.data.dto.Request.ElectionRequest;
import com.semicolon.africa.data.dto.Responses.ElectionResponse;
import com.semicolon.africa.data.model.Candidate;
import com.semicolon.africa.data.model.Election;
import com.semicolon.africa.data.model.Party;
import com.semicolon.africa.data.repositories.ElectionRepository;
import com.semicolon.africa.exception.BusinessLogicException;
import com.semicolon.africa.mapper.CandidateMapper;
import com.semicolon.africa.mapper.ElectionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ElectionServiceImpl implements ElectionService{
    private final ElectionRepository electionRepository;
    @Override
    public ElectionResponse createElection(ElectionRequest electionRequest) {
        Election election = ElectionMapper.map(electionRequest);
        List<Candidate> candidates = new ArrayList<>();
        List<Party> parties = new ArrayList<>();
        for (CandidateRequest candidateRequest : electionRequest.getCandidates()) {
            Candidate candidate = new Candidate();
            candidate.setElection(election);
            candidates.add(candidate);
        }
     election.setCandidates(candidates);
     election.setPoliticalParties(parties);
     Election savedElection = electionRepository.save(election);
         ElectionResponse electionResponse = getElectionResponse(savedElection);
        return electionResponse;
    }
    public Election getElectionById(Long id){
        Election election = electionRepository.findById(id).orElseThrow(()->
              new BusinessLogicException(
                        String.format("election with id %s not found", id)
                ));
        List<CandidateRequest>candidateRequests = new ArrayList<>();
        for (Candidate candidate : election.getCandidates()){
            candidateRequests.add(CandidateMapper.mapR(candidate));
        }
        ElectionRequest electionRequest = ElectionMapper.mapR(election);
        electionRequest.setCandidates(candidateRequests);
        return election;

    }

    @Override
    public Election updateElection() {
        return null;
    }

    private ElectionResponse getElectionResponse(Election savedElection) {
        ElectionResponse electionResponse = new ElectionResponse();
        electionResponse.setId(savedElection.getId());
        electionResponse.setName(savedElection.getName());
        electionResponse.setStartDate(savedElection.getStartDate());
        electionResponse.setEndDate(savedElection.getEndDate());
        electionResponse.setCode(HttpStatus.CREATED.value());
        electionResponse.setMessage("Election created successfully");
        return electionResponse;
    }

}
