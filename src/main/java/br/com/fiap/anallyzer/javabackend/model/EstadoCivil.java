package br.com.fiap.anallyzer.javabackend.model;

public enum EstadoCivil {
  SOLTEIRO("Solteiro"),
  CASADO("Casado"),
  DIVORCIADO("Divorciado"),
  VIUVO("Viúvo"),
  SEPARADO("Separado"),
  UNIÃO_ESTÁVEL("União Estável");

  private String descricao;

  EstadoCivil(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
