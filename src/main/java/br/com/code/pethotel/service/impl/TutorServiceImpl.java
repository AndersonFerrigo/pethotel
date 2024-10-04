package br.com.code.pethotel.service.impl;

import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.mapper.TutorMapper;
import br.com.code.pethotel.model.Tutor;
import br.com.code.pethotel.repository.TutorRepository;
import br.com.code.pethotel.service.PetService;
import br.com.code.pethotel.service.TutorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements TutorService {

	private final TutorMapper tutorMapper;
	private final TutorRepository tutorRepository;
	private final PetService petService;

	public TutorServiceImpl(TutorMapper tutorMapper, TutorRepository tutorRepository, PetService petService) {
		this.tutorMapper = tutorMapper;
		this.tutorRepository = tutorRepository;
		this.petService = petService;
	}

	@Override
	public TutorDto saveTutor(TutorDto tutorDto) {
		Tutor tutorEntity = tutorMapper.toEntity(tutorDto);
		Tutor savedTutor = tutorRepository.save(tutorEntity);

		tutorDto.getPetsDtos()
				.forEach(petDto -> petDto.setTutorDto(tutorMapper.toDto(savedTutor)));

		List<PetDto> savedPetsDto = petService.savePet(tutorDto.getPetsDtos());

		TutorDto savedTutorDto = tutorMapper.toDto(savedTutor);
		savedTutorDto.setPetsDtos(savedPetsDto);

		return savedTutorDto;
	}

	@Override
	public TutorDto updateTutor(TutorDto tutorDto) {
		return null;
	}

	@Override
	public TutorDto findById(long id) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		return tutor.map(tutorMapper::toDto).orElse(null);
	}

	@Override
	public List<TutorDto> tutores() {
		List<TutorDto> tutoresDtos = new ArrayList<TutorDto>();
		List<Tutor> tutores = tutorRepository.findAll();
		tutores.forEach(tutor -> tutoresDtos.add(tutorMapper.toDto(tutor)));
		return tutoresDtos;
	}
}
