package com.example.StudyingSpringBoot.services;

import org.springframework.stereotype.Service;

import com.example.StudyingSpringBoot.models.Task;
import com.example.StudyingSpringBoot.models.Usuario;
import com.example.StudyingSpringBoot.repositories.TaskRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TaskService {
    
    private final TaskRepository taskRepository;

    private final UsuarioService usuarioService;

    public Task findById(String id) {
        
        Task task=this.taskRepository.findById(id).orElse(null);
        if(task==null){
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        return task;
    }

    @Transactional    
    public Task create(Task task) {
        Usuario user = usuarioService.findById(task.getUser().getId());
        task.setId(null); // Garante que o ID seja nulo para criar uma nova tarefa, e não sobreescrever uma existente.
        task.setUser(user);
        task = this.taskRepository.save(task);
        return task;

    }

    @Transactional 
    public Task update(Task task) {
        Task existingTask = findById(task.getId());
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return this.taskRepository.save(existingTask);
    }

    public void delete(String id) {
        Task task = findById(id);
        this.taskRepository.delete(task);
    }
}
