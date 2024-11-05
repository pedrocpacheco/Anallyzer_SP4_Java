package br.com.fiap.anallyzer.javabackend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.anallyzer.javabackend.dto.AuthDTO;
import br.com.fiap.anallyzer.javabackend.dto.LoginResponseDTO;
import br.com.fiap.anallyzer.javabackend.dto.RegisterDTO;
import br.com.fiap.anallyzer.javabackend.repository.UserRepository;
import br.com.fiap.anallyzer.javabackend.model.User;

import br.com.fiap.anallyzer.javabackend.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TokenService tokenService;

  @SuppressWarnings("rawtypes")
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO) {
    // Gerar um token de usuário e senha
    var usuarioSenha = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.senha());
    // Autenticar esse token
    var auth = authenticationManager.authenticate(usuarioSenha);
    var token = tokenService.generateToken((User) auth.getPrincipal());
    return ResponseEntity.ok(new LoginResponseDTO(token));
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
    if (userRepository.findByLogin(registerDTO.login()) != null) {
      return ResponseEntity.badRequest().build();
    }
    String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
    User user = new User(registerDTO.login(), encryptedPassword, registerDTO.role());
    userRepository.save(user);
    return ResponseEntity.ok().build();
  }
}