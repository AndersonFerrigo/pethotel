package br.com.code.pethotel.dto;

import jakarta.validation.constraints.NotBlank;

public class PetDto {

	private long id;

	@NotBlank(message = "O campo tipo é obrigatório")
	private String tipo;

	@NotBlank(message = "O campo raca é obrigatório")
	private String raca;

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;

	@NotBlank(message = "O campo sexo é obrigatório")
	private String sexo;

	@NotBlank(message = "O campo idade é obrigatório")
	private int idade;

	@NotBlank(message = "O campo peso é obrigatório")
	private int peso;

	@NotBlank(message = "O campo observação é obrigatório")
	private String observacao;

	private TutorDto tutorDto;

}
