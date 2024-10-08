package br.com.code.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstadiaDto {

	private int id;

	@NotBlank(message = "Data de entrada do Pet deve ser preenchida")
	private String entrada;
	@NotBlank(message = "Data de saida do Pet deve ser preenchida")
	private String saida;
	@NotBlank(message = "Valor diaria do Pet deve ser preenchida")
	private double valorDiaria;
	private int diasDeEestadia;
	private double valorTotal;

}
