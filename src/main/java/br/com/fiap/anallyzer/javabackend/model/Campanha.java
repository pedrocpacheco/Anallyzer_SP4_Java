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

  @Column(name = "publicoalvo_campanha")
  private String publicoAlvo;

  @Column(name = "periodo_campanha")
  private String periodoRealizacao;

  @Column(name = "clicks_efetivos")
  private Long clicksEfetivos;

  @Column(name = "produto_campanha")
  private String produto;

  @Column(name = "meiocomunicacao_campanha")
  private String meioComunicacao;

  @Column(name = "desc_campanha")
  private String descricao;

  public Campanha(Long id, String titulo, String publicoAlvo, String periodoRealizacao, Long clicksEfetivos,
      String produto, String meioComunicacao, String descricao) {
    this.id = id;
    this.titulo = titulo;
    this.publicoAlvo = publicoAlvo;
    this.periodoRealizacao = periodoRealizacao;
    this.clicksEfetivos = clicksEfetivos;
    this.produto = produto;
    this.meioComunicacao = meioComunicacao;
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
    return "Campanha [id=" + id + ", titulo=" + titulo + ", publicoAlvo=" + publicoAlvo + ", periodoRealizacao="
        + periodoRealizacao + ", clicksEfetivos=" + clicksEfetivos + ", produto=" + produto + ", meioComunicacao="
        + meioComunicacao + ", descricao=" + descricao + "]";
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

  public String getPublicoAlvo() {
    return publicoAlvo;
  }

  public void setPublicoAlvo(String publicoAlvo) {
    this.publicoAlvo = publicoAlvo;
  }

  public String getPeriodoRealizacao() {
    return periodoRealizacao;
  }

  public void setPeriodoRealizacao(String periodoRealizacao) {
    this.periodoRealizacao = periodoRealizacao;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public String getMeioComunicacao() {
    return meioComunicacao;
  }

  public void setMeioComunicacao(String meioComunicacao) {
    this.meioComunicacao = meioComunicacao;
  }
}
