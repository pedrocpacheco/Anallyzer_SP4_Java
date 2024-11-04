package br.com.fiap.anallyzer.javabackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmpresaRequestDTO(

    @NotBlank(message = "O nome da empresa é obrigatório.") @Size(min = 2, max = 100, message = "O nome da empresa deve ter entre 2 e 100 caracteres.") String nome,

    @NotBlank(message = "O CNPJ é obrigatório.") @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos.") String cnpj,

    @NotBlank(message = "O contato é obrigatório.") @Size(min = 10, max = 15, message = "O contato deve ter entre 10 e 15 caracteres.") String contato) {
}
