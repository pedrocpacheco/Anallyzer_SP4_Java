package br.com.fiap.anallyzer.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_SP3_ENDERECO")
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O logradouro é obrigatório.")
  @Size(max = 100, message = "O logradouro deve ter no máximo 100 caracteres.")
  private String logradouro;

  @NotBlank(message = "O número é obrigatório.")
  @Size(max = 10, message = "O número deve ter no máximo 10 caracteres.")
  private String numero;

  @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres.")
  private String complemento;

  @NotBlank(message = "O bairro é obrigatório.")
  @Size(max = 50, message = "O bairro deve ter no máximo 50 caracteres.")
  private String bairro;

  @NotBlank(message = "A cidade é obrigatória.")
  @Size(max = 50, message = "A cidade deve ter no máximo 50 caracteres.")
  private String cidade;

  @NotBlank(message = "O estado é obrigatório.")
  @Size(max = 2, message = "O estado deve ter 2 caracteres.")
  private String estado;

  @NotBlank(message = "O CEP é obrigatório.")
  @Size(max = 10, message = "O CEP deve ter no máximo 10 caracteres.")
  private String cep;

  // Construtor padrão
  public Endereco() {
  }

  // Construtor com parâmetros
  public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado,
      String cep) {
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  // Getters e Setters
  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  @Override
  public String toString() {
    return "Endereco{" +
        "logradouro='" + logradouro + '\'' +
        ", numero='" + numero + '\'' +
        ", complemento='" + complemento + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade='" + cidade + '\'' +
        ", estado='" + estado + '\'' +
        ", cep='" + cep + '\'' +
        '}';
  }
}
