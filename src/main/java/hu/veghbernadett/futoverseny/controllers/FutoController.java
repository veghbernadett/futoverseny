package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.models.Futo;
import hu.veghbernadett.futoverseny.repositories.FutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FutoController {

    @Autowired
    private FutoRepository futoRepository;

    // TODO
    @GetMapping(path = "/futo")
    public Futo getFutto(){

        Futo futo = new Futo();
        futo.setNev("Test Futo");
        futo.setEletkor(22);
        futo.setNem(true);

        return futo;

    }

    @PostMapping(path = "/futomentes")
    public Futo addRunner(@RequestBody Futo futo){
        futoRepository.save(futo);
        return futo;
    }

    //  TODO
    @GetMapping(path = "/futo/{id}")
    public Integer getFutoById(@PathVariable int id){

        return id;
    }
}
