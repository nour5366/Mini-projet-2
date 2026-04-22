package com.nour.series.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nour.series.entites.Pays;
import com.nour.series.repos.PaysRepository;

@RestController
@RequestMapping("/api/pays")
@CrossOrigin("*")
public class PaysRESTController {

    @Autowired
    PaysRepository paysRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pays getPaysById(@PathVariable("id") Long id) {
        return paysRepository.findById(id).get();
    }
}
