package br.com.souza.healthGPT.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class InformationsRequest {

    @NotNull
    private Integer idade;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotBlank
    private String objetivo;

}
