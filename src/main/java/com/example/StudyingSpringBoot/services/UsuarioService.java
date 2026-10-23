package com.example.StudyingSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudyingSpringBoot.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import com.example.StudyingSpringBoot.repositories.TaskRepository;
import com.example.StudyingSpringBoot.models.Usuario;

@Service
@RequiredArgsConstructor 
public class UsuarioService {
    
    private  final UsuarioRepository usuarioRepository;

    private final TaskRepository taskRepository;

    public Usuario findById(String id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElse(null);
        if(usuario == null) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
        return usuario;
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        usuario.setId(null); // Garante que o ID seja nulo para criar um novo usuário, 
        // e não sobreescrever um existente.
        this.taskRepository.saveAll(usuario.getTasks());
        return this.usuarioRepository.save(usuario);
        
    }

    @Transactional 
    public Usuario update(Usuario usuario){
        Usuario existingUsuario = findById(usuario.getId());
        existingUsuario.setSenha(usuario.getSenha());
        return this.usuarioRepository.save(existingUsuario);

    }

    public void delete(String id) {
        Usuario usuario = findById(id);
        this.usuarioRepository.delete(usuario);
    }
}
