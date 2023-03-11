package com.semicolon.africa.services;

import com.github.fge.jsonpatch.JsonPatch;
import com.semicolon.africa.data.dto.Request.RegisterRequest;
import com.semicolon.africa.data.dto.Responses.RegisterResponse;
import com.semicolon.africa.data.model.Voter;

public interface VoterService {
    RegisterResponse registerVoter(RegisterRequest request);
    Voter getVoterById(Long Id);
    Voter getVoterByVoterId(String voterId);
    Voter updateVoter(Long id, JsonPatch updatePayLoad);
    void deleteVoter(Long id);


}
