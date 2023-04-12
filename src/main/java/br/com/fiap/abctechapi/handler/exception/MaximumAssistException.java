package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MaximumAssistException extends RuntimeException{
    private String description;
    public MaximumAssistException(String message, String description){
        super(message);
        this.description = description;
    }
}
