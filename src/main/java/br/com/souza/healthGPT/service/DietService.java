package br.com.souza.healthGPT.service;

import br.com.souza.healthGPT.dto.GPTRequest;
import br.com.souza.healthGPT.dto.GPTResponse;
import br.com.souza.healthGPT.dto.InformationsRequest;
import br.com.souza.healthGPT.openfeign.ChatGPTClient;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DietService {

    private final ChatGPTClient chatGPTClient;
    @Value("${api-key}")
    private String apiKey;
    private final String prompt = "Preciso de uma boa dieta com objetivo de %s. Tenho %s anos, %s de altura e peso %s kg. A dieta deve ser equivalente ao meu peso, altura e idade.";

    public DietService(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }

    public String generate(InformationsRequest request) {
        GPTResponse response = chatGPTClient.generate(
                "Bearer " + apiKey,
                GPTRequest.builder()
                        .prompt(String.format(prompt, request.getObjetivo(), request.getIdade(), request.getAltura(), request.getPeso()))
                        .max_tokens(1000)
                        .n(1)
                        .temperature(new BigDecimal("0.5"))
                        .stop(null)
                        .build());

        return response.getChoices().get(0).getText();
    }
}
