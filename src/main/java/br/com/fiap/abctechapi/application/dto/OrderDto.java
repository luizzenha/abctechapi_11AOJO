package br.com.fiap.abctechapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    @NotNull
    private Long operatorId;
    @NotEmpty
    private List<Long> services;

    @Valid
    private OrderLocationDto start;

    @Valid
    private OrderLocationDto end;
}
