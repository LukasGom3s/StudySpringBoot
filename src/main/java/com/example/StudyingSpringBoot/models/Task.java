package com.example.StudyingSpringBoot.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Task.COLLECTION_NAME)
public class Task {
    public static final String COLLECTION_NAME = "tasks"; // Para garantir o nome da coleção, definimos uma constante com o nome da coleção.
    @Id
    // Indica que esse atributo é o identificador único da entidade, gera ele automaticamente, 
    // e é usado para buscar, atualizar e deletar registros no banco de dados.
    private String id;

    private Usuario user; // Referência ao usuário que criou a tarefa. Relaciomento de associação.

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 500)
    private String description;

}
