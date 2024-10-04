package br.com.code.pethotel.mapper;

import br.com.code.pethotel.dto.PetDto;
import br.com.code.pethotel.model.Pet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetMapper {

	public List<Pet> toEntity(List<PetDto> petDtos) {
		List<Pet> petsToEntity = new ArrayList<Pet>();
		petDtos.forEach(petDto ->
				petsToEntity.add(
					Pet.builder()
							.id(petDto.getId())
							.tipo(petDto.getTipo())
							.raca(petDto.getRaca())
							.nome(petDto.getNome())
							.sexo(petDto.getSexo())
							.idade(petDto.getIdade())
							.peso(petDto.getPeso())
							.observacao(petDto.getObservacao())
							.build())
		);
		return petsToEntity;
	}

	public List<PetDto> toDto (List<Pet> pets){
		List<PetDto> petsToDto = new ArrayList<PetDto>();
		pets.forEach(pet ->
				petsToDto.add(
						PetDto.builder()
								.id(pet.getId())
								.tipo(pet.getTipo())
								.raca(pet.getRaca())
								.nome(pet.getNome())
								.sexo(pet.getSexo())
								.idade(pet.getIdade())
								.peso(pet.getPeso())
								.observacao(pet.getObservacao())
								.build())
		);
		return petsToDto;
	}

}
