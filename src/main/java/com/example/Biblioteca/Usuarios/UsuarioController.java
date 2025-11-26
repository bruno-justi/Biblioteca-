package com.example.Biblioteca.Usuarios;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioController {

        @GetMapping("/usuario")
        public String usuario(){
            return "Is my second message!";
        }
}
