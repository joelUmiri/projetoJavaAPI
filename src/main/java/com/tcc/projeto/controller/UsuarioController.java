package com.tcc.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tcc.projeto.service.UsuarioService;
import com.tcc.projeto.model.Usuario;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /usuarios → listar todos
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }


    // GET /usuarios/{id} → buscar usuário por ID
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .orElse(null); // poderia retornar 404, mas por enquanto null resolve
    }

    // POST /usuarios → criar novo usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    // PUT /usuarios/{id} → atualizar usuário existente
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizar(id, usuario);
    }

    // DELETE /usuarios/{id} → deletar usuário
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
