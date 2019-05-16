package com.relacionamento.table.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleResourceNotFoundExcepition(BusinessException ex){
        ErrorInfo errorInfo =  ErrorInfo.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.PRECONDITION_FAILED.value())
                .title("PRE-CONDIÇÃO FALHOU")
                .message(ex.getMessage())
                .build();
        return  new ResponseEntity<>(errorInfo, HttpStatus.PRECONDITION_FAILED);
    }
}
