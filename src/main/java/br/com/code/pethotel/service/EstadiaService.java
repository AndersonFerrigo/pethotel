package br.com.code.pethotel.service;

import br.com.code.pethotel.model.Estadia;

import java.util.List;
import java.util.Optional;

public interface EstadiaService {

	Estadia createEstadiaPet(Estadia estadia);
	Estadia updateEstadiaPet(Estadia estadia, int id);
	Optional<Estadia> findEstadiaPetById(int id);
	List<Estadia> listAllEstadias();

}
