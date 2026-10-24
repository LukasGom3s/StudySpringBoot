package com.example.StudyingSpringBoot.models;
import org.springframework.data.annotation.Id;
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
public class Task {
    @Id
    // Indica que esse atributo é o identificador único da entidade, gera ele automaticamente, 
    // e é usado para buscar, atualizar e deletar registros no banco de dados.
    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 500)
    private String description;

}
