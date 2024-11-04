package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.EmpresaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.EmpresaResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

  private final EmpresaService empresaService;

  public EmpresaController(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }

  @PostMapping
  public ResponseEntity<EmpresaResponseDTO> criarEmpresa(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
    EmpresaResponseDTO empresaResponseDTO = empresaService.criarEmpresa(empresaRequestDTO);
    return new ResponseEntity<>(empresaResponseDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<EmpresaResponseDTO>> listarTodasEmpresas() {
    List<EmpresaResponseDTO> empresas = empresaService.listarTodasEmpresas();
    return ResponseEntity.ok(empresas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmpresaResponseDTO> listarEmpresaPorId(@PathVariable Long id) {
    EmpresaResponseDTO empresaResponseDTO = empresaService.listarEmpresaPorId(id);
    return ResponseEntity.ok(empresaResponseDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmpresaResponseDTO> atualizarEmpresa(@PathVariable Long id,
      @Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
    EmpresaResponseDTO empresaAtualizada = empresaService.atualizarEmpresa(id,
        empresaRequestDTO);
    return ResponseEntity.ok(empresaAtualizada);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
    empresaService.deletarEmpresa(id);
    return ResponseEntity.noContent().build();
  }
}
