package app.mtab.controllers;

import app.mtab.models.City;
import app.mtab.models.User;
import app.mtab.repositiories.CityRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @CrossOrigin
    @GetMapping("/cities")
    public Iterable<City> getCities() {
        return cityRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/cities")
    public ResponseEntity<?> addCity(@RequestParam String name, @RequestParam String info, @RequestParam String district) {
        try {
            new JSONObject(info);
        } catch (JSONException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        City city = new City();
        city.setName(name);
        city.setInfo(info);
        city.setDistrict(district);
        cityRepository.save(city);
        return new ResponseEntity<City>(city, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/city/{city_id}")
    public ResponseEntity<?> updateCity(@PathVariable Long city_id, @RequestParam String name) {
        Optional<City> city = cityRepository.findById(city_id);
        if (!city.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.get().setName(name);
        cityRepository.save(city.get());
        return new ResponseEntity<City>(city.get(), HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/city/{city_id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long city_id) {
        Optional<City> city = cityRepository.findById(city_id);
        if (!city.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityRepository.delete(city.get());
        return new ResponseEntity<City>(city.get(), HttpStatus.OK);
    }
}
