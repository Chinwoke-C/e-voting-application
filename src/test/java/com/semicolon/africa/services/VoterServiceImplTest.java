package com.semicolon.africa.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.ReplaceOperation;
import com.semicolon.africa.data.dto.Request.RegisterRequest;
import com.semicolon.africa.data.dto.Responses.RegisterResponse;
import com.semicolon.africa.data.model.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class VoterServiceImplTest {
    @Autowired
    private VoterService voterService;
    RegisterRequest request;
    @BeforeEach
    void setUp(){
        request = new RegisterRequest();
        request.setName("Balablu baby");
        request.setPassword("fx1234");
        request.setEmail("test@email.com");
    }

    @Test
    void registerVoterTest() {
        RegisterResponse registerResponse = voterService.registerVoter(request);
        assertThat(registerResponse).isNotNull();
        assertThat(registerResponse.getCode())
                .isEqualTo(HttpStatus.CREATED.value());
    }

   @Test
   void getVoterByIdTest(){
        var registerResponse = voterService.registerVoter(request);
        Voter foundVoter = voterService.getVoterById(registerResponse.getId());
        assertThat(foundVoter).isNotNull();
        assertThat(foundVoter.getName()).isEqualTo(request.getName());
   }

    @Test
    void getVoterByVoterIdTest() {
        RegisterResponse registerResponse = voterService.registerVoter(request);
        Voter foundVoter = voterService.getVoterByVoterId(registerResponse.getVoterId());
        assertThat(foundVoter).isNotNull();
        assertThat(foundVoter.getName()).isEqualTo(request.getName());

    }

    @Test
    void updateVoterTest() throws JsonPointerException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree("babe@Email.com");
        JsonPatch updatePayLoad = new JsonPatch(List.of(
                new ReplaceOperation(new JsonPointer("/email"), node)
        ));
        var registerResponse = voterService.registerVoter(request);
        var updatedVoter = voterService.updateVoter(registerResponse.getId(), updatePayLoad);
        assertThat(updatedVoter).isNotNull();
        assertThat(updatedVoter.getEmail()).isNotNull();

    }

//    @Test
//    void deleteVoter() {
//    }
}