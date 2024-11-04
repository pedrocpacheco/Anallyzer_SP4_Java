package br.com.fiap.anallyzer.javabackend.dto;

public record CampanhaRequestDTO(
    String titulo,
    Long clicksEfetivos,
    String descricao) {

}
