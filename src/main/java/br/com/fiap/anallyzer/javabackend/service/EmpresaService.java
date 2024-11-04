package br.com.fiap.anallyzer.javabackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.javabackend.dto.EmpresaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.EmpresaResponseDTO;
import br.com.fiap.anallyzer.javabackend.model.Empresa;
import br.com.fiap.anallyzer.javabackend.repository.EmpresaRepository;

@Service
public class EmpresaService {

  private final EmpresaRepository empresaRepository;

  public EmpresaService(EmpresaRepository empresaRepository) {
    this.empresaRepository = empresaRepository;
  }

  public EmpresaResponseDTO criarEmpresa(EmpresaRequestDTO empresaRequestDTO) {
    Empresa empresa = fromDTO(empresaRequestDTO);
    Empresa empresaSalva = empresaRepository.save(empresa);
    return toDTO(empresaSalva);
  }

  public List<EmpresaResponseDTO> listarTodasEmpresas() {
    return empresaRepository.findAll()
        .stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  public EmpresaResponseDTO listarEmpresaPorId(Long id) {
    Optional<Empresa> empresaOpt = empresaRepository.findById(id);
    if (empresaOpt.isPresent()) {
      return toDTO(empresaOpt.get());
    } else {
      throw new RuntimeException("Empresa não encontrada com o ID: " + id);
    }
  }

  public EmpresaResponseDTO atualizarEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO) {
    Optional<Empresa> empresaOpt = empresaRepository.findById(id);
    if (empresaOpt.isPresent()) {
      Empresa empresa = empresaOpt.get();
      empresa.setNome(empresaRequestDTO.nome());
      empresa.setCnpj(empresaRequestDTO.cnpj());
      empresa.setContato(empresaRequestDTO.contato());

      Empresa empresaAtualizada = empresaRepository.save(empresa);
      return toDTO(empresaAtualizada);
    } else {
      throw new RuntimeException("Empresa não encontrada com o ID: " + id);
    }
  }

  public void deletarEmpresa(Long id) {
    Optional<Empresa> empresaOpt = empresaRepository.findById(id);
    if (empresaOpt.isPresent()) {
      empresaRepository.deleteById(id);
    } else {
      throw new RuntimeException("Empresa não encontrada com o ID: " + id);
    }
  }

  private Empresa fromDTO(EmpresaRequestDTO dto) {
    Empresa empresa = new Empresa();
    empresa.setNome(dto.nome());
    empresa.setCnpj(dto.cnpj());
    empresa.setContato(dto.contato());
    return empresa;
  }

  private EmpresaResponseDTO toDTO(Empresa empresa) {
    return new EmpresaResponseDTO(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getContato());
  }
}
