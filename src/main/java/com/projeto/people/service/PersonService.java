package com.projeto.people.service;

import com.projeto.people.dto.request.PersonRequestDTO;
import com.projeto.people.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO register(PersonRequestDTO personDTO);

    PersonResponseDTO update(PersonRequestDTO personDTO,  Long id);

    String delete(Long id);
}
