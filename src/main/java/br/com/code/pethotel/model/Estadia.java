package br.com.code.pethotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Estadia {

	@Id
	@GeneratedValue()
	private Long id;
	private String entrada;
	private String saida;
	private int diasDeEestadia;
	private double valorDiaria;
	private double valorTotal;

	@OneToMany(mappedBy = "estadia", cascade = CascadeType.REMOVE)
	private List<Pet> pets;




}
