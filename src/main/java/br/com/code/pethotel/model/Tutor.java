package br.com.code.pethotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Tutor {

	@Id
	@GeneratedValue()
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private char sexo;
	private int idade;
	private String telefone;
	private String endereco;
	private int numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	@OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
	private List<Pet> pets;

}
