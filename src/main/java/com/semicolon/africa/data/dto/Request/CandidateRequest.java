package com.semicolon.africa.data.dto.Request;

import com.semicolon.africa.data.model.Election;
import com.semicolon.africa.data.model.Party;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateRequest {
    private String name;
    private Party party;
    private Election election;
}
