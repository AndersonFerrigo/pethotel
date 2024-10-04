package br.com.code.pethotel.service;

import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.model.Pet;

import java.util.List;

public interface PetService {

	List<PetDto> savePet(List<PetDto> pets);
	List<PetDto> updatePet(List<PetDto> pets);
	List<PetDto> findAllPetsByTutorId(long id);

}
