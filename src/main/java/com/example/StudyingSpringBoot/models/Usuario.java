package com.example.StudyingSpringBoot.models;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// Versão Para Banco de Dados SQL
// Isso define que SpringBoot tem que tratar essa classe como uma tabela no banco de dados, neste caso SQL.
//@Entity
// Isso define o nome da tabela no banco de dados que essa classe vai representar, neste caso "users".
//@Table(name = "users")
// public class UserSQL {
    
// }

// Versão Para Banco de Dados NoSQL MongoDB
// Isso define que SpringBoot tem que tratar essa classe como uma coleção no banco de dados, neste caso MongoDB.
// Indicamos a coleção que essa classe vai representar, neste caso "usuarios".
@Document(collection = Usuario.COLLECTION_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario{
    public static final String COLLECTION_NAME = "usuarios"; // Para garantir o nome da coleção, definimos uma constante com o nome da coleção.
    @Id
    // Indica que esse atributo é o identificador único da entidade, gera ele automaticamente, 
    // e é usado para buscar, atualizar e deletar registros no banco de dados.
    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @Email
    @NotBlank   
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Isso garante que a senha não será retornada em respostas JSON, apenas será aceita em requisições.
    private String senha;
    

    private List<Task> tasks = new ArrayList<Task>();

    
}


