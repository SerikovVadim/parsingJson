package ru.serikov.parsingJson.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.serikov.parsingJson.entity.Person;
import ru.serikov.parsingJson.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void save(Person person){
        personRepository.save(person);
    }

    public void saveAll(Iterable<Person> iterable){
        personRepository.saveAll(iterable);
    }

}
