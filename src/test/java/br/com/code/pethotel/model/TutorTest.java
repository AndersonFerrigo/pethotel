package br.com.code.pethotel.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TutorTest {

	private Tutor tutor;

	@BeforeEach
	public void instatiateTutorWithPet(){
		List<Pet> listPets = new ArrayList<Pet>();

		listPets.add(Pet.builder()
				.id(1L)
				.tipo("Gato")
				.raca("Angora")
				.nome("Fluffy")
				.sexo("F")
				.idade(3)
				.peso(4)
				.observacao("Nenhuma restrição")
				.build()
		);
		tutor = Tutor.builder()
				.id(1L)
				.nome("Anderson")
				.sobrenome("Ferrigo Silva")
				.cpf("35035035099")
				.sexo('M')
				.idade(38)
				.telefone("11999998888")
				.endereco("Rua Andradina")
				.numero(120)
				.bairro("Centro")
				.cidade("Santo Andre")
				.estado("São Paulo")
				.pets(listPets)
			.build();

	}

	@Test
	public void mustNewCreateTutor(){
		Tutor tutor1 = tutor;
		Assertions.assertNotNull(tutor1);
	}

	@Test
	public void mustTutorIsNotNull(){
		Tutor tutor1 = new Tutor();
		Assertions.assertNotNull(tutor1);
	}

	@Test
	public void mustOverrideTutorName(){
		String newTutorName = tutor.getNome();
		Assertions.assertEquals(newTutorName, tutor.getNome());
		String setNewTutorName = "João";
		tutor.setNome(setNewTutorName);
		Assertions.assertNotEquals(newTutorName, tutor.getNome());
	}

}
