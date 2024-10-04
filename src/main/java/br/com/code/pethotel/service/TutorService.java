package br.com.code.pethotel.service;

import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.model.Tutor;

import java.util.List;

public interface TutorService {

	TutorDto saveTutor(TutorDto tutorDto);
	TutorDto updateTutor(TutorDto tutorDto);
	TutorDto findById(long id);
	List<TutorDto> tutores();


}
