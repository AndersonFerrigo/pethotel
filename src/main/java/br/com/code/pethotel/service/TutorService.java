package br.com.code.pethotel.service;

import br.com.code.pethotel.model.Tutor;

import java.util.List;

public interface TutorService {

	Tutor saveTutor(Tutor tutor);
	Tutor updateTutor(Tutor tutor);
	Tutor findById(int id);
	List<Tutor> findAllTutores();


}
