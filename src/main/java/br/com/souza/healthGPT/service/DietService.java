package br.com.souza.healthGPT.service;

import br.com.souza.healthGPT.dto.GPTRequest;
import br.com.souza.healthGPT.dto.GPTResponse;
import br.com.souza.healthGPT.dto.InformationsRequest;
import br.com.souza.healthGPT.openfeign.ChatGPTClient;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class DietService {

    private final ChatGPTClient chatGPTClient;
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String PROMPT = """
            #Contexto
            Você é uma referência e um grande especialista na área de nutrição.
                        
            #Funcao
            Sua funcao é passar dietas específicas para pessoas com diferentes perfis
                        
            #Acao
            Crie uma dieta de acordo com as informações passadas entre as tags <objetivo>, <idade>, <altura>, <peso>. 
            A dieta deve ser de acordo com as informações passadas para atingir o objetivo da pessoa
            Considere apenas 4 tipos de objetivo: Emagrecimento, Ganho de massa muscular, Definicao e hipertrofia. 
            Qualquer coisa diferente disso na tag <objetivo>, retorne a seguinte mensagem: "Objetivo inválido"
                        
            #Exemplo
            Se a pessoa pesa 50kg, tem 22 anos e tem 1.80 metros de  altura, passe uma dieta alinhada com exercicios fisicos para o ganho de massa muscular
                        
            #Parametros
            <objetivo> %s <objetivo>
            <idade> %s anos <idade>
            <altura> %s <altura>
            <peso> %s kg <peso>
            """;

    public DietService(ChatGPTClient chatGPTClient) {
        this.chatGPTClient = chatGPTClient;
    }

    public String generate(InformationsRequest request) {
        GPTResponse response = chatGPTClient.generate(
                "Bearer ".concat(API_KEY),
                GPTRequest.builder()
                        .prompt(String.format(PROMPT, request.getObjetivo(), request.getIdade(), request.getAltura(), request.getPeso()))
                        .max_tokens(1000)
                        .n(1)
                        .temperature(new BigDecimal("1"))
                        .stop(null)
                        .build());

        return response.getChoices().get(0).getText();
    }
}
