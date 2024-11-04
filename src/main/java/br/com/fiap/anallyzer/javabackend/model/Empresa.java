package br.com.fiap.anallyzer.javabackend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "TB_SP3_EMPRESA")
public class Empresa {

  public Empresa(Long id, String nome, String cnpj, String contato, List<Campanha> campanhas,
      @Valid Endereco endereco) {
    this.id = id;
    this.nome = nome;
    this.cnpj = cnpj;
    this.contato = contato;
  }

  public Empresa() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_empresa")
  private Long id;

  @Column(name = "nm_empresa")
  private String nome;

  @Column(name = "cnpj_empresa")
  private String cnpj;

  @Column(name = "ctt_empresa")
  private String contato;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getContato() {
    return contato;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
