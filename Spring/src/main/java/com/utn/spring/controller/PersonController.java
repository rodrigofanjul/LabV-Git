package com.utn.spring.controller;

import com.utn.spring.model.GetSalaryForStudentAImp;
import com.utn.spring.model.GetSalaryForStudentBImp;
import com.utn.spring.model.Person;
import com.utn.spring.model.Student;
import com.utn.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getPerson(){
        return personService.getPerson();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId){
        return personService.getPersonById(personId);
    }

    @PostMapping("/")
    public void addPerson(@RequestBody @Valid Person person){

        /*Student studentA = new Student();
        studentA.setIGetSalaryForStudent(new GetSalaryForStudentAImp());

        Student studentB = new Student();
        studentB.setIGetSalaryForStudent(new GetSalaryForStudentBImp());*/

        personService.add(person);

    }


}
