package com.example.StudyingSpringBoot.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.StudyingSpringBoot.models.Usuario;

// Classes Repository servem para abstrair a camada de acesso 
// a dados, ou seja, elas são responsáveis por interagir com o banco de dados 
// e realizar operações de CRUD (Create, Read, Update, Delete) nas entidades do sistema.

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // A interface UsuarioRepository herda da interface MongoRepository, 
    // que é fornecida pelo Spring Data MongoDB. 
    // Isso significa que a interface UsuarioRepository herda todos os métodos de CRUD 
    // (como save, findById, findAll, deleteById, etc.) para a entidade Usuario.
    
}
