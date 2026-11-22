package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Usuario actualizar(
            Long id,
            Usuario usuario) {

        Usuario actual = repository.findById(id)
                .orElse(null);

        if (actual != null) {

            actual.setNombre(
                    usuario.getNombre());

            actual.setCorreo(
                    usuario.getCorreo());

            actual.setPassword(
                    usuario.getPassword());

            actual.setActivo(
                    usuario.getActivo());

            actual.setRol(
                    usuario.getRol());

            return repository.save(actual);

        }

        return null;
    }
}