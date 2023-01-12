package com.tkach.md.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
    private String exception;
    private String details;
}
