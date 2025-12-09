package com.example.Biblioteca.Usuarios;

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

        if (usuarioModel.getLoans() != null) {
            dto.setLoans(
                    usuarioModel.getLoans()
                            .stream()
                            .map(loan ->
                                    new UsuarioDTO.LoanInfo(
                                            loan.getId(),              // ← ID DO LOAN
                                            loan.getBook().getId(),     // ← ID DO LIVRO
                                            loan.getStatus(),            // ← STATUS DO LOAN
                                            loan.getLoanDate().toString(), // ← DATA DE EMPRÉSTIMO
                                            loan.getReturnDate() != null ? loan.getReturnDate().toString() : null
                                    )
                            )
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public UsuarioModel mapEntity(UsuarioDTO usuarioDTO) {
        UsuarioModel model = new UsuarioModel();

        model.setId(usuarioDTO.getId());
        model.setNome(usuarioDTO.getNome());
        model.setImgUrl(usuarioDTO.getImgUrl());
        model.setIdade(usuarioDTO.getIdade());
        model.setEmail(usuarioDTO.getEmail());
        model.setCpf(usuarioDTO.getCpf());

        return model;
    }
}


