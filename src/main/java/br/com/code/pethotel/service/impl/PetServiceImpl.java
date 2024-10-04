package br.com.code.pethotel.service.impl;

import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.mapper.PetMapper;
import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.repository.PetRepository;
import br.com.code.pethotel.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

	private final PetMapper petMapper;
	private final PetRepository petRepository;

	public PetServiceImpl(PetMapper petMapper, PetRepository petRepository) {
		this.petMapper = petMapper;
		this.petRepository = petRepository;
	}

	@Override
	public List<PetDto> savePet(List<PetDto> petsDto) {
		List<Pet> pets = petMapper.toEntity(petsDto);
		List<Pet> savedPets = petRepository.saveAll(pets);
		return petMapper.toDto(savedPets);
	}

	@Override
	public List<PetDto> updatePet(List<PetDto> pets) {
		return List.of();
	}

	@Override
	public List<PetDto> findAllPetsByTutorId(long id) {
		return List.of();
	}
}
