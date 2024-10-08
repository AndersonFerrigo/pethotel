package br.com.code.pethotel.mapper;

import br.com.code.pethotel.dto.EstadiaDto;
import br.com.code.pethotel.model.Estadia;
import org.springframework.stereotype.Component;

@Component
public class EstadiaMapper {

	public Estadia toEntity(EstadiaDto estadiaDto){
		return Estadia.builder()
				.id(estadiaDto.getId())
				.entrada(estadiaDto.getEntrada())
				.saida(estadiaDto.getSaida())
				.valorDiaria(estadiaDto.getValorDiaria())
				.diasDeEestadia(estadiaDto.getDiasDeEestadia())
				.valorTotal(estadiaDto.getValorTotal())
				.build();
	}

	public EstadiaDto toDto(Estadia estadia){
		return EstadiaDto.builder()
				.id(estadia.getId())
				.entrada(estadia.getEntrada())
				.saida(estadia.getSaida())
				.valorDiaria(estadia.getValorDiaria())
				.diasDeEestadia(estadia.getDiasDeEestadia())
				.valorTotal(estadia.getValorTotal())
				.build();
	}

}
