package br.com.code.pethotel.service.impl;

import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.repository.PetRepository;
import br.com.code.pethotel.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;

	public PetServiceImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public List<Pet> savePet(List<Pet> pets) {
		return petRepository.saveAll(pets);
	}

	@Override
	public List<Pet> updatePet(List<Pet> pets) {
		return List.of();
	}

	@Override
	public List<Pet> findAllPetsByTutorId(int id) {
		return List.of();
	}
}
