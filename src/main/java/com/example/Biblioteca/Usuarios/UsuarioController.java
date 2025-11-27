package com.example.Biblioteca.Usuarios;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Adicionar usuário (CREATE)
        @PostMapping("/criar")
        public String criarUsuario() {
            return "Usuário criado com sucesso!";
        }

        //Mostrar todos os usuarios (READ)
        @GetMapping("/listar")
        public List<UsuarioModel> listarUsuarios() {
            return usuarioService.listarUsuarios();
        }

        //Mostrar usuario por ID (READ)
        @GetMapping("/listarID")
        public String mostrarTodosOsUsuariosPorId() {
            return "Mostrar Ninja por ID";
        }

        //Alterar dados dos usuarios (UPDATE)
        @PutMapping("/alterarID")
        public String alterarUsuario() {
            return "Alterar Ninja por ID";
        }

        //Deletar usuário (DELETE)
        @DeleteMapping("/deletarID")
        public String deletarUsuarioPorId() {
            return "Usuário deletado por ID";
        }
}
