package br.com.fiap.anallyzer.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.javabackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
