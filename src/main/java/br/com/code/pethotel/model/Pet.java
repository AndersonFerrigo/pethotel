package br.com.code.pethotel.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Pet {

	@Id
	@GeneratedValue()
	private int id;
	private String tipo;
	private String raca;
	private String nome;
	private String sexo;
	private int idade;
	private int peso;
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "tutor_id", nullable = false)
	private Tutor tutor;

	@ManyToOne
	@JoinColumn(name = "estadia_id", nullable = false)
	private Estadia estadia;

}
