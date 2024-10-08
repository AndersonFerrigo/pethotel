package br.com.code.pethotel.facade;

import br.com.code.pethotel.dto.EstadiaDto;
import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.mapper.EstadiaMapper;
import br.com.code.pethotel.mapper.PetMapper;
import br.com.code.pethotel.mapper.TutorMapper;
import br.com.code.pethotel.model.Estadia;
import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.model.Tutor;
import br.com.code.pethotel.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Facade {

	private final TutorService tutorService;
	private final TutorMapper tutorMapper;
	private final PetMapper petMapper;
	private final EstadiaMapper estadiaMapper;

	public TutorDto createTutor(TutorDto tutorDto){

		Tutor tutor = tutorMapper.toEntity(tutorDto);
		List<Pet> pets = petMapper.toEntity(tutorDto.getPets());

		for (PetDto petDto : tutorDto.getPets()) {
			Estadia estadia = new Estadia();
			estadia.setEntrada(petDto.getEstadia().getEntrada());
			estadia.setSaida(petDto.getEstadia().getSaida());
			estadia.setValorDiaria(petDto.getEstadia().getValorDiaria());

			pets.get(tutorDto.getPets().indexOf(petDto)).setEstadia(estadia);
		}

		tutor.setPets(pets);
		Tutor tutorCreated = tutorService.saveTutor(tutor);

		List<PetDto> createdPetDtos = petMapper.toDto(tutorCreated.getPets());
		TutorDto createdTutorDto = tutorMapper.toDto(tutor);

		for (Pet pet : tutorCreated.getPets()) {
			EstadiaDto estadiaDto = new EstadiaDto();
			estadiaDto.setId(pet.getEstadia().getId());
			estadiaDto.setEntrada(pet.getEstadia().getEntrada());
			estadiaDto.setSaida(pet.getEstadia().getSaida());
			estadiaDto.setValorDiaria(pet.getEstadia().getValorDiaria());
			estadiaDto.setDiasDeEestadia(pet.getEstadia().getDiasDeEestadia());
			estadiaDto.setValorTotal(pet.getEstadia().getValorTotal());

			createdPetDtos.get(tutorCreated.getPets().indexOf(pet)).setEstadia(estadiaDto);
		}
		createdTutorDto.setPets(createdPetDtos);


		return createdTutorDto;
	}

	}


