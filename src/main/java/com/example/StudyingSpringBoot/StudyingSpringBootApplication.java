package com.example.StudyingSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyingSpringBootApplication {

	// Método static fica associado apenas a classe, não a instância da classe. 
	// Ele pode ser chamado sem criar uma instância da classe, é como se fosse uma função de uma biblioteca.
	// Alem disso, ele só pode alterar variáveis estáticas da classe também, não variáveis de instância.
	public static void main(String[] args) {
		SpringApplication.run(StudyingSpringBootApplication.class, args);
	}

}
