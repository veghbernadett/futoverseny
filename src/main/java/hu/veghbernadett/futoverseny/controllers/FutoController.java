package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.domain.models.Futo;
import hu.veghbernadett.futoverseny.domain.response.FutoDto;
import hu.veghbernadett.futoverseny.repositories.FutoRepository;
import hu.veghbernadett.futoverseny.services.transformers.FutoDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FutoController {

    @Autowired
    private FutoRepository futoRepository;

    @Autowired
    private FutoDtoTransformer futoDtoTransformer;


    // összes futó
    @GetMapping("/getRunners")
    public List<FutoDto> getRunners() {

        return futoDtoTransformer.transform(futoRepository.findAll());
    }


    // futó felvétele
    @PostMapping(path = "/addRunner")
    public Futo addRunner(@RequestBody Futo futo) {
        futoRepository.save(futo);
        return futo;
    }



}
