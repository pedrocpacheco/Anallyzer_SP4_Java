package br.com.fiap.anallyzer.javabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.anallyzer.javabackend.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
