package com.projeto.people.service;

import com.projeto.people.dto.request.PersonRequestDTO;
import com.projeto.people.dto.response.PersonResponseDTO;
import com.projeto.people.entity.Person;
import com.projeto.people.repository.PersonRepository;
import com.projeto.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;
    @Override
    public PersonResponseDTO findById(Long id) {
        Person person = returnPerson(id);
        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return null;
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        return null;
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {
        Person person = returnPerson(id);

    }

    @Override
    public String delete(Long id) {
        return null;
    }

    private Person returnPerson(Long id) {
        personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person wasn't found  in the database"));
    }
}
