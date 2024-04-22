package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.models.Verseny;
import hu.veghbernadett.futoverseny.repositories.EredmenyRepository;
import hu.veghbernadett.futoverseny.repositories.VersenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VersenyController {

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    // adott verseny összes futójának neve és időeredménye emelkedő sorrendben
    @GetMapping("/getRaceRunners/{id}")
    Verseny getById(@PathVariable int id) {

        return versenyRepository.findById(id).get();
    }

}
