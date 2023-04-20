package com.projeto.people.controller;

import com.projeto.people.dto.request.PersonRequestDTO;
import com.projeto.people.dto.response.PersonResponseDTO;
import com.projeto.people.entity.Person;
import com.projeto.people.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    private PersonService personService;
    @GetMapping(value = "/{id}")
    private ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    private ResponseEntity<List<PersonResponseDTO>> findById() {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    private ResponseEntity<PersonResponseDTO> register (@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder) {

        PersonResponseDTO personResponseDTO = personService.register(personRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    //@PutMapping
    //private ResponseEntity<PersonResponseDTO> update(@ResponseBody Person personRequestDTO, @PathVariable(name="id") Long id) {
            //return ResponseEntity.ok().body(personService.update(id, personRequestDTO));
    //}
}
