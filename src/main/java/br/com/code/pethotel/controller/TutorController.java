package br.com.code.pethotel.controller;


import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.facade.Facade;
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

	private final Facade facade;

	private final TutorService tutorService;
	private final TutorMapper tutorMapper;
	private final PetMapper petMapper;
	private final EstadiaMapper estadiaMapper;


	@PostMapping("/tutor")
	public TutorDto saveTutor(@RequestBody TutorDto tutorDto){
		return facade.createTutor(tutorDto);

	}

	@GetMapping("/tutor/{id}")
	public TutorDto findTutorByID(@PathVariable("id") Long id){
		Tutor tutor = tutorService.findById(id);
		return tutorMapper.toDto(tutor);
	}

	@GetMapping("/tutor")
	public List<TutorDto> findAll(){
		List<Tutor> tutores = tutorService.findAllTutores();
		return tutorMapper.retrieveAllTutores(tutores);
	}

}
