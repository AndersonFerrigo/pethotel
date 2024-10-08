package br.com.code.pethotel.service.impl;

import br.com.code.pethotel.model.Estadia;
import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.model.Tutor;
import br.com.code.pethotel.repository.TutorRepository;
import br.com.code.pethotel.service.EstadiaService;
import br.com.code.pethotel.service.PetService;
import br.com.code.pethotel.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

	private final TutorRepository tutorRepository;
	private final PetService petService;
	private final EstadiaService estadiaService;

	@Override
	public Tutor saveTutor(Tutor tutor) {
		Tutor savedTutor = tutorRepository.save(tutor);
		tutor.getPets().forEach(pet -> pet.setTutor(savedTutor));

		for (Pet pet : tutor.getPets()) {
			Estadia savedEstadia = estadiaService.createEstadiaPet(pet.getEstadia());
			pet.setEstadia(savedEstadia);
		}

		List<Pet> savedPets = petService.savePet(tutor.getPets());
		savedTutor.setPets(savedPets);

		return savedTutor;
	}

	@Override
	public Tutor updateTutor(Tutor tutor) {
		return null;
	}

	@Override
	public Tutor findById(int id) {
		Optional<Tutor> tutor = tutorRepository.findById(id);
		return tutor.orElse(null);
	}

	@Override
	public List<Tutor> findAllTutores() {
		return tutorRepository.findAll();
	}
}
