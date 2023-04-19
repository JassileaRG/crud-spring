package com.projeto.people.util;

import com.projeto.people.dto.request.PersonRequestDTO;
import com.projeto.people.dto.response.PersonResponseDTO;
import com.projeto.people.entity.Person;

public class PersonMapper {
    public Person toPerson(PersonRequestDTO personDTO) {

        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person) {

        return new PersonResponseDTO(person);
    }
}
