package com.example.Biblioteca.Usuarios.repository;

import com.example.Biblioteca.Usuarios.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
