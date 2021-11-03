package com.example.demo.web;


import com.example.demo.model.Cabin;
import com.example.demo.services.ServicesCabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerCabin {
    @Autowired
    private ServicesCabin service;
    @GetMapping("/all")
    public List<Cabin> getCabins(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int cabinId) {
        return service.getCabin(cabinId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return service.save(cabin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return service.update(cabin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cabinId) {
        return service.deleteCabin(cabinId);
    }
}
