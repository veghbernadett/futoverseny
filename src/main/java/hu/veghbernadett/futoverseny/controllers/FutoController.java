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

/*
    // TODO
    @GetMapping(path = "/futo")
    public Futo getFutto(){

        Futo futo = new Futo();
        futo.setNev("Test Futo");
        futo.setEletkor(22);
        futo.setNem(true);

        return futo;

    }


    //  TODO
    @GetMapping(path = "/futo/{id}")
    public Integer getFutoById(@PathVariable int id){

        return id;
    }

// TODO
    @GetMapping("/items/{id}")
    Futo getById(@PathVariable int id) {

        return futoRepository.findById(id).get();
    } */


}
