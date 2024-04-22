package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.models.Eredmeny;
import hu.veghbernadett.futoverseny.models.Verseny;
import hu.veghbernadett.futoverseny.repositories.EredmenyRepository;
import hu.veghbernadett.futoverseny.repositories.VersenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EredmenyController {

    @Autowired
    private EredmenyRepository eredmenyRepository;
    @Autowired
    private VersenyRepository versenyRepository;

    @PostMapping("/addResult")
    public void addResult(@RequestBody Eredmeny eredmeny) {
        eredmenyRepository.save(eredmeny);
    }

    @GetMapping("/getAverageTime/{versenyAzonosito}")
    public ResponseEntity<Double> getAverageTime(@PathVariable int versenyAzonosito) {
        Optional<Verseny> optionalRace = versenyRepository.findById(versenyAzonosito);
        if (optionalRace.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Verseny race = optionalRace.get();

        List<Eredmeny> results = eredmenyRepository.findByVersenyAzonosito(versenyAzonosito);
        if (results.isEmpty()) {
            return ResponseEntity.ok(0.0);
        }

        // Atlag ido szamolasa
        double totalTime = results.stream().mapToDouble(Eredmeny::getIdoeredmeny).sum();
        double averageTime = totalTime / results.size();

        return ResponseEntity.ok(averageTime);
    }


}
