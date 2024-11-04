package br.com.fiap.anallyzer.javabackend.dto;

public record EmpresaResponseDTO(
    Long id,
    String nome,
    String cnpj,
    String contato) {
}
