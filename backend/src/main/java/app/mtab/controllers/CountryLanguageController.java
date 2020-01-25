package app.mtab.controllers;

import app.mtab.models.Countrylanguage;
import app.mtab.repositiories.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryLanguageController {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    @CrossOrigin
    @GetMapping("/countrieslanguage")
    public Iterable<Countrylanguage> getCountrieslanguage() {
        return countryLanguageRepository.findAll();
    }
}
