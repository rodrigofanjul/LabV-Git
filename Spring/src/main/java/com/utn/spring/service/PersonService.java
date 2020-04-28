package com.utn.spring.service;

import com.utn.spring.model.Person;
import com.utn.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired //lo inicializa automaticamente antes de hacer cualquier cosa, durante el compilado
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(final Person person){
        personRepository.save(person);
    }

    public List<Person> getPerson() {
        return personRepository.findAll();
    }

    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId).get();
    }
}
