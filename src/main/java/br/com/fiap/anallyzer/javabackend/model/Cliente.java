package br.com.fiap.anallyzer.javabackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SP3_CLIENTE")
public class Cliente {

  public Cliente() {
  }

  public Cliente(Long id, String nome, String email, String password, Escolaridade escolaridade,
      EstadoCivil estadoCivil, Genero genero, Campanha campanha) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.password = password;
    this.escolaridade = escolaridade;
    this.estadoCivil = estadoCivil;
    this.genero = genero;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nm_cliente")
  private String nome;

  @Column(name = "em_cliente")
  private String email;

  @Column(name = "pswd_cliente")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "escolaridade")
  private Escolaridade escolaridade;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_civil")
  private EstadoCivil estadoCivil;

  @Enumerated(EnumType.STRING)
  @Column(name = "genero")
  private Genero genero;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Escolaridade getEscolaridade() {
    return escolaridade;
  }

  public void setEscolaridade(Escolaridade escolaridade) {
    this.escolaridade = escolaridade;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

}
