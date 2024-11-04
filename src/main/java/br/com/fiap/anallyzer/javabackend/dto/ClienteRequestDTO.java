package br.com.fiap.anallyzer.javabackend.dto;

import br.com.fiap.anallyzer.javabackend.model.Escolaridade;
import br.com.fiap.anallyzer.javabackend.model.EstadoCivil;
import br.com.fiap.anallyzer.javabackend.model.Genero;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequestDTO(

    @NotBlank(message = "O nome é obrigatório.") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.") String nome,

    @NotBlank(message = "O email é obrigatório.") @Email(message = "Formato de email inválido.") String email,

    @NotBlank(message = "A senha é obrigatória.") @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.") String password,

    @NotNull(message = "A escolaridade é obrigatória.") Escolaridade escolaridade,

    @NotNull(message = "O estado civil é obrigatório.") EstadoCivil estadoCivil,

    @NotNull(message = "O gênero é obrigatório.") Genero genero) {
}
