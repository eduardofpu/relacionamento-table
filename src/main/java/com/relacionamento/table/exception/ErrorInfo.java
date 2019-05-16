package com.relacionamento.table.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

    private String title;
    private int status;
    private String message;
    private Long timestamp;

}
