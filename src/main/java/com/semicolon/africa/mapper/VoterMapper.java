package com.semicolon.africa.mapper;

import com.semicolon.africa.data.dto.Request.RegisterRequest;
import com.semicolon.africa.data.model.Gender;
import com.semicolon.africa.data.model.Vote;
import com.semicolon.africa.data.model.Voter;

public class VoterMapper {
    public static Voter map(RegisterRequest request){
        Voter voter = new Voter();
        voter.setName(request.getName());
        voter.setPassword(request.getPassword());
        voter.setEmail(request.getEmail());
        voter.setAge(request.getAge());
        voter.setGender(Gender.valueOf(request.getGender()));
        return voter;
    }
}
