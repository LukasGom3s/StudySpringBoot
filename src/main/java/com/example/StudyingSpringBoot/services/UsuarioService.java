package com.example.StudyingSpringBoot.services;

import org.springframework.stereotype.Service;

import com.example.StudyingSpringBoot.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import com.example.StudyingSpringBoot.models.Task;
import com.example.StudyingSpringBoot.models.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findById(String id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
        return usuario;
    }

    public Usuario create(Usuario usuario) {
        usuario.setId(null); // Garante que o ID seja nulo para criar um novo usuário,
        // e não sobreescrever um existente.
        return this.usuarioRepository.save(usuario);

    }

    public Usuario update(Usuario usuario) {
        Usuario existingUsuario = findById(usuario.getId());
        existingUsuario.setSenha(usuario.getSenha());
        return this.usuarioRepository.save(existingUsuario);

    }

    public void delete(String id) {
        Usuario usuario = findById(id);
        this.usuarioRepository.delete(usuario);
    }

    public Task findTaskById(String usuarioId, String taskId) {
        Usuario usuario = findById(usuarioId);
        return usuario.getTasks().stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task não encontrada com o ID: " + taskId));
    }

    public Usuario addTask(String usuarioId, Task novaTask) {
        Usuario usuario = findById(usuarioId);
        novaTask.setId(java.util.UUID.randomUUID().toString()); // Gera ID manual
        usuario.getTasks().add(novaTask);
        return usuarioRepository.save(usuario);
    }

    public Usuario updateTask(String usuarioId, String idTask, Task taskAtualizada) {
        Usuario usuario = findById(usuarioId);

        for (Task t : usuario.getTasks()) {
            if (t.getId().equals(idTask)) {
                t.setTitle(taskAtualizada.getTitle());
                t.setDescription(taskAtualizada.getDescription());
                break;
            }
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario removeTask(String usuarioId, String taskId) {
        Usuario usuario = findById(usuarioId);
        usuario.getTasks().removeIf(t -> t.getId().equals(taskId));
        return usuarioRepository.save(usuario);
    }
}
