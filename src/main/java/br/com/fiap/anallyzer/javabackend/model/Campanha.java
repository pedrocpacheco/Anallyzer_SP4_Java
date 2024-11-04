package br.com.fiap.anallyzer.javabackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SP3_CAMPANHA")
public class Campanha {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_campanha")
  private Long id;

  @Column(name = "titulo_campanha")
  private String titulo;

  @Column(name = "clicks_efetivos")
  private Long clicksEfetivos;

  @Column(name = "desc_campanha")
  private String descricao;

  public Campanha(Long id, Long clicksEfetivos, String titulo, String descricao) {
    this.id = id;
    this.titulo = titulo;
    this.clicksEfetivos = clicksEfetivos;
    this.descricao = descricao;
  }

  public Campanha() {
  }

  public Campanha(Long clicksEfetivos, Empresa empresa) {
    this.clicksEfetivos = clicksEfetivos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClicksEfetivos() {
    return clicksEfetivos;
  }

  public void setClicksEfetivos(Long clicksEfetivos) {
    this.clicksEfetivos = clicksEfetivos;
  }

  @Override
  public String toString() {
    return "Campanha{" +
        "id=" + id +
        ", clicksEfetivos=" + clicksEfetivos +
        '}';
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
