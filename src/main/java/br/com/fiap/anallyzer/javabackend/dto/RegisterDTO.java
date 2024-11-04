package br.com.fiap.anallyzer.javabackend.dto;

import br.com.fiap.anallyzer.javabackend.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}