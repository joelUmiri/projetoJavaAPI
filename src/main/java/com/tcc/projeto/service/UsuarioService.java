package com.tcc.projeto.service;

import com.tcc.projeto.model.Usuario;
import org.springframework.stereotype.Service;
import com.tcc.projeto.repository.UsuarioRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id); // garante que está atualizando o certo
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
