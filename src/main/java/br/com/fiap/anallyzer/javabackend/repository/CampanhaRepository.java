package br.com.fiap.anallyzer.javabackend.repository;

import br.com.fiap.anallyzer.javabackend.model.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
}
