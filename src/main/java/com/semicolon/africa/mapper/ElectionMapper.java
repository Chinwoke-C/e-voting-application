package com.semicolon.africa.mapper;

import com.semicolon.africa.data.dto.Request.ElectionRequest;
import com.semicolon.africa.data.model.Election;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ElectionMapper {
    public static Election map(ElectionRequest request) {
        Election election = new Election();
        election.setName(request.getName());
        election.setStartDate(LocalDateTime.now().toString());
        election.setEndDate(LocalDate.of(2023,2, 27).toString());
        return election;
    }
    public static ElectionRequest mapR(Election request) {
        ElectionRequest election = new ElectionRequest();
        election.setName(request.getName());
        election.setStartDate(LocalDateTime.now().toString());
        election.setEndDate(LocalDate.of(2023,2, 27).toString());
        return election;
    }
}
