package ucsal.gestaoaluno.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;



@Entity

public class Aluno {

	

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String matricula;

	private String nome;

	private Integer semestre;

	

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	

	public String getMatricula() {

		return matricula;

	}

	public void setMatricula(String matricula) {

		this.matricula = matricula;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public Integer getSemestre() {

		return semestre;

	}

	public void setSemestre(Integer semestre) {

		this.semestre = semestre;

	}



}