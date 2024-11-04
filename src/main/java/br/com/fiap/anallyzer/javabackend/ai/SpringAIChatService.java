package br.com.fiap.anallyzer.javabackend.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.javabackend.model.Campanha;
import br.com.fiap.anallyzer.javabackend.repository.CampanhaRepository;

@Service
public class SpringAIChatService {
  private final ChatClient.Builder chatClientBuilder;

  @Autowired
  private final CampanhaRepository campanhaRepository; // Adicione o repositório aqui

  public SpringAIChatService(ChatClient.Builder chatClientBuilder, CampanhaRepository campanhaRepository) {
    this.chatClientBuilder = chatClientBuilder;
    this.campanhaRepository = campanhaRepository; // Injete o repositório
  }

  public String run(String userPrompt) {
    var chatClient = chatClientBuilder.build();
    return chatClient
        .prompt()
        .user(userPrompt)
        .call()
        .content()
        .replace("\n", "");
  }

  public String getCampaignDetailsById(Long id) {
    Campanha campanha = campanhaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Campanha não encontrada"));

    return String.format(
        "Estou fazendo uma campanha de marketing com as seguintes informações: Título: %s, Descrição: %s | Poderia me informar se você pensa se a mesma terá sucesso?",
        campanha.getTitulo(), campanha.getDescricao());
  }
}
