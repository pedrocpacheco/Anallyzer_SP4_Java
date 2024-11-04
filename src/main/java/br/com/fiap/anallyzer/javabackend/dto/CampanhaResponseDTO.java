package br.com.fiap.anallyzer.javabackend.dto;

public record CampanhaResponseDTO(
    Long id,
    String titulo,
    Long clicksEfetivos,
    String descricao) {
}
