package br.com.fiap.anallyzer.javabackend.ai;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/springai")
@Tag(name = "Basic - Spring AI")
public class SpringAIChatController {

  private final SpringAIChatService chatService;

  public SpringAIChatController(SpringAIChatService chatService) {
    this.chatService = chatService;
  }

  @GetMapping("/generate/{id}")
  public ResponseEntity<Map> generate(@PathVariable Long id) {
    // Aqui você deve obter os detalhes da campanha pelo ID.
    String campaignDetails = chatService.getCampaignDetailsById(id); // Método que você irá criar
    String analysisResult = chatService.run(campaignDetails);
    return new ResponseEntity<>(Map.of("ollama", analysisResult), HttpStatus.OK);
  }
}
