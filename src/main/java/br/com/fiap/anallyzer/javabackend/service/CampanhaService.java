package br.com.fiap.anallyzer.javabackend.service;

import br.com.fiap.anallyzer.javabackend.dto.CampanhaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.CampanhaResponseDTO;
import br.com.fiap.anallyzer.javabackend.model.Campanha;
import br.com.fiap.anallyzer.javabackend.repository.CampanhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampanhaService {

  private final CampanhaRepository campanhaRepository;

  public CampanhaService(CampanhaRepository campanhaRepository) {
    this.campanhaRepository = campanhaRepository;
  }

  public List<CampanhaResponseDTO> listarCampanhas() {
    return campanhaRepository.findAll().stream()
        .map(campanha -> new CampanhaResponseDTO(
            campanha.getId(),
            campanha.getTitulo(),
            campanha.getClicksEfetivos(),
            campanha.getDescricao(),
            campanha.getPublicoAlvo(),
            campanha.getPeriodoRealizacao(),
            campanha.getProduto(), // Novo atributo
            campanha.getMeioComunicacao() // Novo atributo
        ))
        .collect(Collectors.toList());
  }

  public CampanhaResponseDTO criarCampanha(CampanhaRequestDTO campanhaRequest) {
    Campanha campanha = new Campanha();
    campanha.setTitulo(campanhaRequest.titulo());
    campanha.setClicksEfetivos(campanhaRequest.clicksEfetivos());
    campanha.setDescricao(campanhaRequest.descricao());
    campanha.setPublicoAlvo(campanhaRequest.publicoAlvo());
    campanha.setPeriodoRealizacao(campanhaRequest.periodoRealizacao());
    campanha.setProduto(campanhaRequest.produto()); // Novo atributo
    campanha.setMeioComunicacao(campanhaRequest.meioComunicacao()); // Novo atributo
    campanha = campanhaRepository.save(campanha);
    return new CampanhaResponseDTO(
        campanha.getId(),
        campanha.getTitulo(),
        campanha.getClicksEfetivos(),
        campanha.getDescricao(),
        campanha.getPublicoAlvo(),
        campanha.getPeriodoRealizacao(),
        campanha.getProduto(), // Novo atributo
        campanha.getMeioComunicacao() // Novo atributo
    );
  }

  public Optional<CampanhaResponseDTO> visualizarCampanha(Long id) {
    return campanhaRepository.findById(id)
        .map(campanha -> new CampanhaResponseDTO(
            campanha.getId(),
            campanha.getTitulo(),
            campanha.getClicksEfetivos(),
            campanha.getDescricao(),
            campanha.getPublicoAlvo(),
            campanha.getPeriodoRealizacao(),
            campanha.getProduto(), // Novo atributo
            campanha.getMeioComunicacao() // Novo atributo
        ));
  }

  public CampanhaResponseDTO atualizarCampanha(Long id, CampanhaRequestDTO campanhaRequest) {
    Campanha campanha = campanhaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Campanha não encontrada"));

    campanha.setTitulo(campanhaRequest.titulo());
    campanha.setClicksEfetivos(campanhaRequest.clicksEfetivos());
    campanha.setDescricao(campanhaRequest.descricao());
    campanha.setPublicoAlvo(campanhaRequest.publicoAlvo());
    campanha.setPeriodoRealizacao(campanhaRequest.periodoRealizacao());
    campanha.setProduto(campanhaRequest.produto());
    campanha.setMeioComunicacao(campanhaRequest.meioComunicacao());

    campanha = campanhaRepository.save(campanha);

    return new CampanhaResponseDTO(
        campanha.getId(),
        campanha.getTitulo(),
        campanha.getClicksEfetivos(),
        campanha.getDescricao(),
        campanha.getPublicoAlvo(),
        campanha.getPeriodoRealizacao(),
        campanha.getProduto(),
        campanha.getMeioComunicacao());
  }

  public void deletarCampanha(Long id) {
    campanhaRepository.deleteById(id);
  }
}
