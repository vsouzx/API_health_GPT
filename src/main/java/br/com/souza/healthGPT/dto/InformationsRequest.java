package br.com.souza.healthGPT.dto;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class InformationsRequest {

    @NotBlank
    private int idade;
    @NotBlank
    private BigDecimal peso;
    @NotBlank
    private BigDecimal altura;
    @NotBlank
    private String objetivo;

}
