package br.com.code.pethotel.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadiaDto {

	private Long id;

	@NotBlank(message = "Data de entrada do Pet deve ser preenchida")
	private String entrada;
	@NotBlank(message = "Data de saida do Pet deve ser preenchida")
	private String saida;
	@NotBlank(message = "Valor diaria do Pet deve ser preenchida")
	private double valorDiaria;
	private int diasDeEestadia;
	private double valorTotal;

}
