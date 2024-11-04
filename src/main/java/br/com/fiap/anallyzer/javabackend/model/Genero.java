package br.com.fiap.anallyzer.javabackend.model;

public enum Genero {
  MASCULINO("Masculino"),
  FEMININO("Feminino"),
  OUTRO("Outro"),
  NAO_INFORMAR("Não informar");

  private String descricao;

  Genero(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
