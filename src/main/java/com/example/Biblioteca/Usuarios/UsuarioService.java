package com.example.Biblioteca.Usuarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    // Listar todos os usuários
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::mapDTO)
                .collect(Collectors.toList());
    }

    // Listar todos os usuários por ID
   public UsuarioDTO listarUsuarioPorId(Long id) {
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.map(usuarioMapper::mapDTO).orElse(null);
   }

   // Criar um novo usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioModel usuario = usuarioMapper.mapEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.mapDTO(usuario);
    }

    // Deletar usuário - TEM QUE SER UM método VOID
    public void deletarUsuarioPorId(Long id) {
         usuarioRepository.deleteById(id);
    }

    // Atualizar usuário
    public UsuarioDTO atualizarUsuario(Long id,  UsuarioDTO usuarioDTO) {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioModel usuarioAtualizado = usuarioMapper.mapEntity(usuarioDTO);
            usuarioAtualizado.setId(id);
            UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioAtualizado);
            return usuarioMapper.mapDTO(usuarioSalvo);
        }
        return null; // Caso não exista o Id solicitado para atualização.
    }
}
