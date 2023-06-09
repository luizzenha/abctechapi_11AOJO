package br.com.fiap.abctechapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssistResponseDto {
    private Long id;
    private String title;
    private String description;
}
