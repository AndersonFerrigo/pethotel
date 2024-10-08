package br.com.code.pethotel.controller;


import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.mapper.EstadiaMapper;
import br.com.code.pethotel.mapper.PetMapper;
import br.com.code.pethotel.mapper.TutorMapper;
import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.model.Tutor;
import br.com.code.pethotel.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pethotel")
public class TutorController {

	private final TutorService tutorService;
	private final TutorMapper tutorMapper;
	private final PetMapper petMapper;
	private final EstadiaMapper estadiaMapper;


	@PostMapping("/tutor")
	public TutorDto saveTutor(@RequestBody TutorDto tutorDto){

		Tutor tutor = tutorMapper.toEntity(tutorDto);
		List<Pet> pets = petMapper.toEntity(tutorDto.getPets());

		tutorDto.getPets()
				.forEach(petDto ->
						pets.forEach(pet -> pet.setEstadia(estadiaMapper.toEntity(petDto.getEstadia()))));

		tutor.setPets(pets);
		Tutor tutorCreated = tutorService.saveTutor(tutor);

		List<PetDto> createdPetDtos = petMapper.toDto(tutorCreated.getPets());
		TutorDto createdTutorDto = tutorMapper.toDto(tutor);

		tutorCreated.getPets()
				.forEach(petsDto -> createdPetDtos
						.forEach(petDto -> petDto.setEstadia(estadiaMapper.toDto(petsDto.getEstadia()))));

		createdTutorDto.setPets(createdPetDtos);
		return createdTutorDto;

	}

	@GetMapping("/tutor/{id}")
	public TutorDto findTutorByID(@PathVariable("id") int id){
		Tutor tutor = tutorService.findById(id);
		return tutorMapper.toDto(tutor);
	}

	@GetMapping("/tutor")
	public List<TutorDto> findAll(){
		List<Tutor> tutores = tutorService.findAllTutores();
		return tutorMapper.retrieveAllTutores(tutores);
	}

}
