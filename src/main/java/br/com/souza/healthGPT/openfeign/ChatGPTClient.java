package br.com.souza.healthGPT.openfeign;

import br.com.souza.healthGPT.dto.GPTRequest;
import br.com.souza.healthGPT.dto.GPTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "openapiGPT", url = "https://api.openai.com/v1/engines/text-davinci-003/completions")
public interface ChatGPTClient {

    @PostMapping
    public GPTResponse generate(@RequestHeader(value = "Authorization") String authorizationHeader, @RequestBody GPTRequest request);
}
