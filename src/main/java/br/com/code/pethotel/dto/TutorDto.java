package br.com.code.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class TutorDto {

	private long id;

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;

	@NotBlank(message = "O campo sobrenome é obrigatório")
	private String sobrenome;

	@NotBlank(message = "O campo cpf é obrigatório")
	private String cpf;

	@NotBlank(message = "O campo sexo é obrigatório")
	private char sexo;

	@NotBlank(message = "O campo idade é obrigatório")
	private int idade;

	@NotBlank(message = "O campo telefone é obrigatório")
	private String telefone;

	@NotBlank(message = "O campo endereco é obrigatório")
	private String endereco;

	@NotBlank(message = "O campo numero é obrigatório")
	private int numero;

	@NotBlank(message = "O campo bairro é obrigatório")
	private String bairro;

	@NotBlank(message = "O campo cep é obrigatório")
	private String cep;

	@NotBlank(message = "O campo cidade é obrigatório")
	private String cidade;

	@NotBlank(message = "O campo estado é obrigatório")
	private String estado;

	private List<PetDto> petsDtos;

}
