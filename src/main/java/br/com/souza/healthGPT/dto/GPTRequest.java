package br.com.souza.healthGPT.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GPTRequest {

    private String prompt;
    private int max_tokens;
    private int n;
    private String stop;
    private BigDecimal temperature;

}
