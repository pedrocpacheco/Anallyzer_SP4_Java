package br.com.fiap.anallyzer.javabackend.dto;

import br.com.fiap.anallyzer.javabackend.model.Escolaridade;
import br.com.fiap.anallyzer.javabackend.model.EstadoCivil;
import br.com.fiap.anallyzer.javabackend.model.Genero;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String email,
    Escolaridade escolaridade,
    EstadoCivil estadoCivil,
    Genero genero) {
}
