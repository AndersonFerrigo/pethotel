package br.com.code.pethotel.service.impl;

import br.com.code.pethotel.model.Estadia;
import br.com.code.pethotel.repository.EstadiaRepository;
import br.com.code.pethotel.service.EstadiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadiaServiceImpl implements EstadiaService {

	private final EstadiaRepository estadiaRepository;

	@Override
	public Estadia createEstadiaPet(Estadia estadia) {
		estadia.setDiasDeEestadia(calculaDiasEstadiaPet(estadia.getEntrada(), estadia.getSaida()));
		estadia.setValorTotal(valorTotalEstadia(estadia.getEntrada(), estadia.getSaida(), estadia.getValorDiaria()));
		return estadiaRepository.save(estadia);
	}

	@Override
	public Estadia updateEstadiaPet(Estadia estadia, Long id) {
		Optional<Estadia> retrivedEstadia = estadiaRepository.findById(id);

		Estadia estadiaToUpdate = Estadia.builder()
				.entrada(retrivedEstadia.get().getEntrada())
				.saida(retrivedEstadia.get().getSaida())
				.valorDiaria(estadia.getValorDiaria())
				.build();

		estadiaToUpdate.setDiasDeEestadia(calculaDiasEstadiaPet(estadia.getEntrada(), estadia.getSaida()));
		estadiaToUpdate.setValorTotal(valorTotalEstadia(estadia.getEntrada(), estadia.getSaida(), estadia.getValorDiaria()));

		return estadiaRepository.save(estadiaToUpdate);
	}

	@Override
	public Optional<Estadia> findEstadiaPetById(Long id) {
		return estadiaRepository.findById(id);

	}

	@Override
	public List<Estadia> listAllEstadias() {
		return estadiaRepository.findAll();
	}

	 int calculaDiasEstadiaPet(String dataEntrada, String dataSaida){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateEntrada = LocalDate.parse(dataEntrada, formatter);
		LocalDate dateSaida = LocalDate.parse(dataSaida, formatter);

		Period days = Period.between(dateEntrada, dateSaida);
		return days.getDays();

	}

	double valorTotalEstadia(String dataEntrada, String dataSaida, Double valorDiaria){
		int daysToStay = calculaDiasEstadiaPet(dataEntrada, dataSaida);
		return (double) Math.multiplyExact(daysToStay, valorDiaria.longValue());
	}


}
