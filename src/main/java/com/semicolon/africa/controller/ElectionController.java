package com.semicolon.africa.controller;

import com.semicolon.africa.data.dto.Request.ElectionRequest;
import com.semicolon.africa.data.dto.Responses.ElectionResponse;
import com.semicolon.africa.services.ElectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/election")
@AllArgsConstructor
public class ElectionController {
    private final ElectionService electionService;

    @PostMapping("/createElection")
    public ResponseEntity<?> createElection(@RequestBody ElectionRequest electionRequest){
        ElectionResponse response = electionService.createElection(electionRequest);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }
    @GetMapping("{electionId}")
    public ResponseEntity<?> findElectionById(@PathVariable Long electionId){
        var foundElection = electionService.getElectionById(electionId);
        return ResponseEntity.status(HttpStatus.OK).body(foundElection);
    }
}
