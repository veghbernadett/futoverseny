package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.models.Eredmeny;
import hu.veghbernadett.futoverseny.models.Futo;
import hu.veghbernadett.futoverseny.repositories.EredmenyRepository;
import hu.veghbernadett.futoverseny.repositories.FutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FutoController {

    @Autowired
    private FutoRepository futoRepository;


    // összes futó
    @GetMapping("/getRunners")
    public List<Futo> getRunners() {

        return futoRepository.findAll();
    }


    // futó felvétele
    @PostMapping(path = "/addRunner")
    public Futo addRunner(@RequestBody Futo futo) {
        futoRepository.save(futo);
        return futo;
    }



}
