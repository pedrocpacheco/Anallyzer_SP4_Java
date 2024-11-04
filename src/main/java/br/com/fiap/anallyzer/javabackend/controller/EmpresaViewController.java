package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.EmpresaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.EmpresaResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.EmpresaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaViewController {

  private final EmpresaService empresaService;

  public EmpresaViewController(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }

  @GetMapping
  public String listarTodasEmpresas(Model model) {
    List<EmpresaResponseDTO> empresas = empresaService.listarTodasEmpresas();
    model.addAttribute("empresas", empresas);
    return "empresas/listar";
  }

  @GetMapping("/{id}")
  public String visualizarEmpresa(@PathVariable Long id, Model model) {
    EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(id);
    model.addAttribute("empresa", empresa);
    return "empresas/visualizar";
  }

  @GetMapping("/novo")
  public String novaEmpresa(Model model) {
    model.addAttribute("empresaRequestDTO", new EmpresaRequestDTO("", "", ""));
    return "empresas/novo";
  }

  @PostMapping("/novo")
  public String criarEmpresa(@ModelAttribute EmpresaRequestDTO empresaRequestDTO) {
    empresaService.criarEmpresa(empresaRequestDTO);
    return "redirect:/empresas";
  }

  @GetMapping("/editar/{id}")
  public String editarEmpresa(@PathVariable Long id, Model model) {
    EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(id);
    model.addAttribute("empresa", empresa);
    return "empresas/editar";
  }

  @PostMapping("/editar/{id}")
  public String atualizarEmpresa(@PathVariable Long id, @ModelAttribute EmpresaRequestDTO empresaRequestDTO) {
    empresaService.atualizarEmpresa(id, empresaRequestDTO);
    return "redirect:/empresas";
  }

  @GetMapping("/deletar/{id}")
  public String deletarEmpresa(@PathVariable Long id) {
    empresaService.deletarEmpresa(id);
    return "redirect:/empresas";
  }
}
