package com.semicolon.africa.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.semicolon.africa.data.dto.Request.RegisterRequest;
import com.semicolon.africa.data.dto.Responses.RegisterResponse;
import com.semicolon.africa.services.VoterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/voter")
@AllArgsConstructor
public class VoterController {
    private final VoterService voterService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = voterService.registerVoter(registerRequest);
        return ResponseEntity.status(registerResponse.getCode()).body(registerResponse);

    }
    @GetMapping("{voterId}")
    public ResponseEntity<?> findVoterByVoterId(@PathVariable String voterId){
        var foundVoter = voterService.getVoterByVoterId(voterId);
        return ResponseEntity.status(HttpStatus.OK).body(foundVoter);
    }
    @GetMapping("/voter/{Id}")
    public ResponseEntity<?> findVoterById(@PathVariable Long Id){
        var foundVoterById = voterService.getVoterById(Id);
        return ResponseEntity.status(HttpStatus.OK).body(foundVoterById);
    }
    @PatchMapping(value= "{id}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updatePassenger(@PathVariable Long id, @RequestBody JsonPatch updatePatch){
        try{
            var response = voterService.updateVoter(id, updatePatch);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    public ResponseEntity<?> deleteVoter(@PathVariable Long Id){
        voterService.deleteVoter(Id);

        return ResponseEntity.ok("Passenger deleted successfully");
    }

}
