package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.CampanhaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.CampanhaResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.CampanhaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/campanhas")
public class CampanhaController {

  private final CampanhaService campanhaService;

  public CampanhaController(CampanhaService campanhaService) {
    this.campanhaService = campanhaService;
  }

  @GetMapping
  public String listarCampanhas(Model model) {
    List<CampanhaResponseDTO> campanhas = campanhaService.listarCampanhas();
    model.addAttribute("campanhas", campanhas);
    return "listar"; // nome da view para listar campanhas
  }

  @GetMapping("/novo")
  public String mostrarFormularioCadastro(Model model) {
    model.addAttribute("campanha", new CampanhaRequestDTO("", null, "", "", null, "", "")); // Atualizado
    return "novo"; // nome da view para criar nova campanha
  }

  @PostMapping
  public String criarCampanha(@ModelAttribute CampanhaRequestDTO campanhaRequest) {
    campanhaService.criarCampanha(campanhaRequest);
    return "redirect:/api/campanhas"; // redireciona para a lista de campanhas
  }

  @GetMapping("/{id}")
  public String visualizarCampanha(@PathVariable Long id, Model model) {
    CampanhaResponseDTO campanhaResponse = campanhaService.visualizarCampanha(id)
        .orElseThrow(() -> new IllegalArgumentException("Campanha não encontrada"));
    model.addAttribute("campanha", campanhaResponse);
    return "visualizar"; // nome da view para visualizar campanha
  }

  @GetMapping("/editar/{id}")
  public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
    CampanhaResponseDTO campanhaResponse = campanhaService.visualizarCampanha(id)
        .orElseThrow(() -> new IllegalArgumentException("Campanha não encontrada"));
    CampanhaRequestDTO campanhaRequest = new CampanhaRequestDTO(
        campanhaResponse.titulo(),
        campanhaResponse.clicksEfetivos(),
        campanhaResponse.descricao(),
        campanhaResponse.publicoAlvo(), // Novo atributo
        campanhaResponse.periodoRealizacao(), // Novo atributo
        campanhaResponse.produto(), // Novo atributo
        campanhaResponse.meioComunicacao() // Novo atributo
    );
    model.addAttribute("campanha", campanhaRequest);
    model.addAttribute("id", id);
    return "editar"; // nome da view para editar campanha
  }

  @PostMapping("/editar/{id}")
  public String atualizarCampanha(@PathVariable Long id, @ModelAttribute CampanhaRequestDTO campanhaRequest) {
    campanhaService.atualizarCampanha(id, campanhaRequest);
    return "redirect:/api/campanhas"; // redireciona para a lista de campanhas
  }

  @GetMapping("/deletar/{id}")
  public String deletarCampanha(@PathVariable Long id) {
    campanhaService.deletarCampanha(id);
    return "redirect:/api/campanhas"; // redireciona para a lista de campanhas
  }
}
