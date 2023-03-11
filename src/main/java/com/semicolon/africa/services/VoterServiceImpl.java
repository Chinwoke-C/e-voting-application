package com.semicolon.africa.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.semicolon.africa.data.dto.Request.RegisterRequest;
import com.semicolon.africa.data.dto.Responses.RegisterResponse;
import com.semicolon.africa.data.model.Voter;
import com.semicolon.africa.data.repositories.VoterRepository;
import com.semicolon.africa.exception.BusinessLogicException;
import com.semicolon.africa.mapper.VoterMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class VoterServiceImpl implements VoterService {
    private final VoterRepository voterRepository;
    public ModelMapper mapper = new ModelMapper();

    @Override
    public RegisterResponse registerVoter(RegisterRequest request) {
        Voter voter = VoterMapper.map(request);
        voter.setCreatedAt(LocalDateTime.now().toString());
        voter.setVoterId(UUID.randomUUID().toString());
        Voter savedVoter = voterRepository.save(voter);
        RegisterResponse registerResponse  = getRegisterResponse(savedVoter);
        return registerResponse;
    }

    @Override
    public Voter getVoterById(Long Id) {
        return voterRepository.findById(Id).orElseThrow(()->
                new BusinessLogicException(
                        String.format("voter with id %s not found", Id)
                ));
    }

    @Override
    public Voter getVoterByVoterId(String voterId) {
        return voterRepository.findByVoterId(voterId);
    }

    @Override
    public Voter updateVoter(Long id, JsonPatch updatePayLoad) {
        ObjectMapper objectMapper = new ObjectMapper();
        Voter foundVoter = getVoterById(id);
        JsonNode node = objectMapper.convertValue(foundVoter, JsonNode.class);
        try {
            JsonNode updatedNode = updatePayLoad.apply(node);
            var updatedVoter = objectMapper.convertValue(updatedNode, Voter.class);
            updatedVoter = voterRepository.save(updatedVoter);
            return updatedVoter;

        } catch (JsonPatchException e) {
            log.error(e.getMessage());
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteVoter(Long id) {
        voterRepository.deleteById(id);
    }

    private static RegisterResponse getRegisterResponse(Voter savedVoter) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(savedVoter.getId());
        registerResponse.setCode(HttpStatus.CREATED.value());
        registerResponse.setSuccess(true);
        registerResponse.setMessage("Voter Registration Successful");
        registerResponse.setVoterId(savedVoter.getVoterId());
        return registerResponse;
    }
}
