package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.CampanhaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.CampanhaResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.CampanhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaController {

  private final CampanhaService campanhaService;

  public CampanhaController(CampanhaService campanhaService) {
    this.campanhaService = campanhaService;
  }

  @PostMapping
  public ResponseEntity<CampanhaResponseDTO> criarCampanha(@RequestBody CampanhaRequestDTO campanhaRequestDTO) {
    CampanhaResponseDTO campanhaResponseDTO = campanhaService.criarCampanha(campanhaRequestDTO);
    return new ResponseEntity<>(campanhaResponseDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<CampanhaResponseDTO>> listarTodasCampanhas() {
    List<CampanhaResponseDTO> campanhas = campanhaService.listarCampanhas();
    return ResponseEntity.ok(campanhas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CampanhaResponseDTO> listarCampanhaPorId(@PathVariable Long id) {
    CampanhaResponseDTO campanhaResponseDTO = campanhaService.visualizarCampanha(id)
        .orElseThrow(() -> new IllegalArgumentException("Campanha não encontrada"));
    return ResponseEntity.ok(campanhaResponseDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CampanhaResponseDTO> atualizarCampanha(@PathVariable Long id,
      @RequestBody CampanhaRequestDTO campanhaRequestDTO) {
    CampanhaResponseDTO campanhaAtualizada = campanhaService.atualizarCampanha(id, campanhaRequestDTO);
    return ResponseEntity.ok(campanhaAtualizada);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarCampanha(@PathVariable Long id) {
    campanhaService.deletarCampanha(id);
    return ResponseEntity.noContent().build();
  }
}
