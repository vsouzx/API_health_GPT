package br.com.souza.healthGPT.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class InformationsRequest {

    private int idade;
    private BigDecimal peso;
    private BigDecimal altura;
    private String objetivo;

}
