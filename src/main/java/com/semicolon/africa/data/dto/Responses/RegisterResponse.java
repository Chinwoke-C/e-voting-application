package com.semicolon.africa.data.dto.Responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private Long id;
    private String message;
    private int code;
    private  boolean isSuccess;
    private String voterId;


}
