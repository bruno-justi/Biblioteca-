package com.example.Biblioteca.Usuarios;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Adicionar usuário (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: " + novoUsuario.getNome() + " (ID): " + novoUsuario.getId());
    }

    //Mostrar todos os usuarios (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    //Mostrar usuario por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.listarUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o (ID) " + id + " não foi encontrado.");
        }
    }

    //Alterar dados dos usuarios (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado) {
        UsuarioDTO usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o (ID) " + id + " não foi encontrado.");
        }
    }

    //Deletar usuário (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuarioPorId(@PathVariable Long id) {
        if (usuarioService.listarUsuarioPorId(id) != null) {
            usuarioService.deletarUsuarioPorId(id);
            return ResponseEntity.ok("Usuário com ID: "+ id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o (ID) " + id + " não foi encontrado.");
        }
    }
}
