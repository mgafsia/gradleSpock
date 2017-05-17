package com.mga.restcontroller;

import com.mga.model.Person;
import com.mga.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/api/persons")
public class PersonRestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getAllPersons(){
        return new ResponseEntity<>((Collection<Person>) personRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        return  new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }
 }
