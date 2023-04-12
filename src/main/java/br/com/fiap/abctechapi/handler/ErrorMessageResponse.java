package br.com.fiap.abctechapi.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageResponse {
    private String message;
    private String description;
    private Integer statusCode;
}
