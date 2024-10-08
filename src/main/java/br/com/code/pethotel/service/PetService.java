package br.com.code.pethotel.service;

import br.com.code.pethotel.model.Pet;

import java.util.List;

public interface PetService {

	List<Pet> savePet(List<Pet> pets);
	List<Pet> updatePet(List<Pet> pets);
	List<Pet> findAllPetsByTutorId(int id);

}
