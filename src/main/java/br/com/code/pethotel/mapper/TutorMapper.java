package br.com.code.pethotel.mapper;

import br.com.code.pethotel.dto.TutorDto;
import br.com.code.pethotel.model.Tutor;
import org.springframework.stereotype.Component;

@Component
public class TutorMapper {

	public Tutor toEntity(TutorDto tutorDto){
		return Tutor.builder()
				.id(tutorDto.getId())
				.nome(tutorDto.getNome())
				.sobrenome(tutorDto.getSobrenome())
				.cpf(tutorDto.getCpf())
				.sexo(tutorDto.getSexo())
				.idade(tutorDto.getIdade())
				.telefone(tutorDto.getTelefone())
				.endereco(tutorDto.getEndereco())
				.numero(tutorDto.getNumero())
				.bairro(tutorDto.getBairro())
				.cep(tutorDto.getCep())
				.cidade(tutorDto.getCidade())
				.estado(tutorDto.getEstado())
				.build();
	}

	public TutorDto toDto(Tutor tutor){
		return TutorDto.builder()
				.id(tutor.getId())
				.nome(tutor.getNome())
				.sobrenome(tutor.getSobrenome())
				.cpf(tutor.getCpf())
				.sexo(tutor.getSexo())
				.idade(tutor.getIdade())
				.telefone(tutor.getTelefone())
				.endereco(tutor.getEndereco())
				.numero(tutor.getNumero())
				.bairro(tutor.getBairro())
				.cep(tutor.getCep())
				.cidade(tutor.getCidade())
				.estado(tutor.getEstado())
				.build();
	}

}
