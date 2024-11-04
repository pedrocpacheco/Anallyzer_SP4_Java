package br.com.fiap.anallyzer.javabackend.dto;

public record CampanhaResponseDTO(
    Long id,
    String titulo,
    Long clicksEfetivos,
    String descricao,
    String publicoAlvo,
    String periodoRealizacao,
    String produto,
    String meioComunicacao) {
}
