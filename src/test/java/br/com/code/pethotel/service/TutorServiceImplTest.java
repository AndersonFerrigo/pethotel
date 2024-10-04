package br.com.code.pethotel.service;

import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.mapper.TutorMapper;
import br.com.code.pethotel.model.Pet;
import br.com.code.pethotel.model.Tutor;
import br.com.code.pethotel.repository.TutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TutorServiceImplTest {

	@Mock
	private final TutorMapper tutorMapper;

	@Mock
	private final TutorRepository tutorRepository;

	public TutorServiceImplTest(TutorMapper tutorMapper, TutorRepository tutorRepository) {
		this.tutorMapper = tutorMapper;
		this.tutorRepository = tutorRepository;
	}

	private TutorDto tutorDto;

	@BeforeEach
	public void instatiateTutorWithPet(){
		List<PetDto> listPetsDto = new ArrayList<PetDto>();

		listPetsDto.add(PetDto.builder()
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
		tutorDto = TutorDto.builder()
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
				.petsDtos(listPetsDto)
				.build();

	}




}
