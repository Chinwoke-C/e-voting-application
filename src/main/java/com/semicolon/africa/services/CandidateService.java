package com.semicolon.africa.services;

import com.semicolon.africa.data.dto.Request.CandidateRequest;
import com.semicolon.africa.data.dto.Request.ElectionRequest;
import com.semicolon.africa.data.dto.Responses.CandidateResponse;

public interface CandidateService {
    CandidateResponse createElection(CandidateRequest request);
}
