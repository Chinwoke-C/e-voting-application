package com.semicolon.africa.data.dto.Responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ElectionResponse {
    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private String message;
    private int code;

}
