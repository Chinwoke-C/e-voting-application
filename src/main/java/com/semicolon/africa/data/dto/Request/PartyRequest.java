package com.semicolon.africa.data.dto.Request;

import com.semicolon.africa.data.model.Candidate;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyRequest {
    private String name;
    private String abbreviation;
   // private List<CandidateRequest> candidates;
}
