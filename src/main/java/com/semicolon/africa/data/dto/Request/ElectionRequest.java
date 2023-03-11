package com.semicolon.africa.data.dto.Request;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectionRequest {
private String name;

private String startDate;
private String endDate;
private List<CandidateRequest> candidates;
//private List<PartyRequest> parties;
}
