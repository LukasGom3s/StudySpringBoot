package com.example.StudyingSpringBoot.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.StudyingSpringBoot.models.Task;

@Repository 
public interface TaskRepository extends MongoRepository<Task, String> {
    // A interface TaskRepository herda da interface MongoRepository, 
    // que é fornecida pelo Spring Data MongoDB. 
    // Isso significa que a interface TaskRepository herda todos os métodos de CRUD 
    // (como save, findById, findAll, deleteById, etc.) para a entidade Task.

    
}
