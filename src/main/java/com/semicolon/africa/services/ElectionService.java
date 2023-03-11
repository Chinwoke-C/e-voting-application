package com.semicolon.africa.services;

import com.semicolon.africa.data.dto.Request.ElectionRequest;
import com.semicolon.africa.data.dto.Responses.ElectionResponse;
import com.semicolon.africa.data.model.Election;

public interface ElectionService {
    ElectionResponse createElection(ElectionRequest electionRequest);
    Election getElectionById(Long id);
    Election updateElection();
}
