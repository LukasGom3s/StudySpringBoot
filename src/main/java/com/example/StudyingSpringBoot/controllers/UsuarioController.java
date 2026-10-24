package com.example.StudyingSpringBoot.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.StudyingSpringBoot.models.Task;
import com.example.StudyingSpringBoot.models.Usuario;
import com.example.StudyingSpringBoot.services.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping ("/usuario")
@Validated
@RequiredArgsConstructor 
public class UsuarioController {
    
    private final UsuarioService usuarioService;

    // localhost:8080/usuario/1
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable String id) {
        Usuario usuario = this.usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping 
    public ResponseEntity<Void> create(@RequestBody Usuario usuario) {
        this.usuarioService.create(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        this.usuarioService.update(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // localhost:8080/usuario/1/2
    @GetMapping("/{idUsuario}/{idTask}")
    public ResponseEntity<Task> getTaskById(@PathVariable String idUsuario, @PathVariable String idTask) {
        Task task = this.usuarioService.findTaskById(idUsuario, idTask);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<Void> addTask(@PathVariable String idUsuario, @RequestBody Task novaTask) {
        this.usuarioService.addTask(idUsuario, novaTask);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaTask.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idUsuario}/{idTask}")
    public ResponseEntity<Void> updateTask(@PathVariable String idUsuario, @PathVariable String idTask, @RequestBody Task taskAtualizada) {
        taskAtualizada.setId(idTask); // Garante que o ID da task seja mantido
        this.usuarioService.updateTask(idUsuario, idTask, taskAtualizada);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/{idUsuario}/{idTask}")
    public ResponseEntity<Void> deleteTask(@PathVariable String idUsuario, @PathVariable String idTask) {
        this.usuarioService.removeTask(idUsuario, idTask);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idUsuario}/tasks")
    public ResponseEntity<java.util.List<Task>> getAllTasks(@PathVariable String idUsuario) {
        Usuario usuario = this.usuarioService.findById(idUsuario);
        return ResponseEntity.ok().body(usuario.getTasks());
    }
}
