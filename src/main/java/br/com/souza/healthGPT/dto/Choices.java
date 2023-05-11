package br.com.souza.healthGPT.dto;

import lombok.Data;

@Data
public class Choices {

    private String text;
    private Integer index;
    private String finish_reason;

}
