package com.example.Biblioteca.Usuarios.controler.controlerUI;

import com.example.Biblioteca.Usuarios.UsuarioDTO;
import com.example.Biblioteca.Usuarios.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarios /ui")
public class UsuarioControllerUI {

    private UsuarioService usuarioService;

    public UsuarioControllerUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Mostrar todos os usuarios (READ)
    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "Usuários Listados.";
    }
}
