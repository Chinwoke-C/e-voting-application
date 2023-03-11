package com.semicolon.africa.mapper;

import com.semicolon.africa.data.dto.Request.CandidateRequest;
import com.semicolon.africa.data.model.Candidate;
import com.semicolon.africa.data.model.Party;

public class CandidateMapper {
    public static Candidate map(CandidateRequest request){
        Candidate candidate = new Candidate();
        candidate.setName(request.getName());
        candidate.setParty(request.getParty());
        candidate.setElection(request.getElection());
        return candidate;
    }

    public static CandidateRequest mapR(Candidate candidate) {
        CandidateRequest request = new CandidateRequest();
        request.setName(candidate.getName());
        request.setParty(candidate.getParty());
        request.setElection(candidate.getElection());
        return request;
    }
}
