package ru.serikov.parsingJson.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.serikov.parsingJson.entity.Person;
import ru.serikov.parsingJson.service.PersonService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //добавление всех записей в бд из файла
    @GetMapping("json")
    public void json() {
        //Путь должен быть на латинском
        //        URL url = this.getClass().getClassLoader().getResource("car.json");

//       if(url != null){
        //путь ручками набираем
        File file = new File("C:\\Users\\Вадим\\IdeaProjects\\parsingJson\\src\\main\\resources\\people.json");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> list = objectMapper.readValue(file, new TypeReference<List<Person>>() {
            });

            personService.saveAll(list);
            logger.info("All records saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

//       } else logger.info("url is null");
    }

}
