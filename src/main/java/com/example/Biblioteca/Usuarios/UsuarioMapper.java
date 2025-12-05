package com.example.Biblioteca.Usuarios;

import com.example.Biblioteca.Loan.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDTO mapDTO(UsuarioModel usuarioModel) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuarioModel.getId());
        dto.setNome(usuarioModel.getNome());
        dto.setImgUrl(usuarioModel.getImgUrl());
        dto.setIdade(usuarioModel.getIdade());
        dto.setEmail(usuarioModel.getEmail());
        dto.setCpf(usuarioModel.getCpf());

        // loans virão aqui depois
        return dto;
    }

    public UsuarioModel mapEntity(UsuarioDTO usuarioDTO) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setImgUrl(usuarioDTO.getImgUrl());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        return usuarioModel;
    }
}
