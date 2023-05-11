package br.com.souza.healthGPT.dto;

import java.util.List;
import lombok.Data;

@Data
public class GPTResponse {

    private List<Choices> choices;

}
