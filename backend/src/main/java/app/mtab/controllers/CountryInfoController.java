package app.mtab.controllers;

import app.mtab.models.Countryinfo;
import app.mtab.repositiories.CountryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryInfoController {

    @Autowired
    private CountryInfoRepository countryInfoRepository;

    @CrossOrigin
    @GetMapping("/countriesinfo")
    public Iterable<Countryinfo> getCountriesInfo() {
        return countryInfoRepository.findAll();
    }
}
