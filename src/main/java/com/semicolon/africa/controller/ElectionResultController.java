package com.semicolon.africa.controller;

import com.semicolon.africa.data.model.ElectionResult;
import com.semicolon.africa.services.ElectionResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/electionResult")
@AllArgsConstructor
public class ElectionResultController {
    private final ElectionResultService electionResultService;
    @GetMapping("/{electionId}")
    public ResponseEntity<?> findElectionResult(@PathVariable Long electionId){
        var foundResults = electionResultService.getElectionResults(electionId);
        return ResponseEntity.status(HttpStatus.OK).body(foundResults);
    }

}
