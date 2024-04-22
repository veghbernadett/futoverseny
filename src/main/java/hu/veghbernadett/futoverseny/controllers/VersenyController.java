package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.models.Verseny;
import hu.veghbernadett.futoverseny.repositories.EredmenyRepository;
import hu.veghbernadett.futoverseny.repositories.VersenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VersenyController {

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    // adott verseny összes futójának neve és időeredménye emelkedő sorrendben
    @GetMapping("/getRaceRunners/{versenyAzonosito}")
    public List<Object[]> getRaceRunners(@PathVariable int versenyAzonosito) {
        List<Object[]> results = versenyRepository.findRaceResultsById(versenyAzonosito);
        return results.stream()
                .sorted((r1, r2) -> Integer.compare((int) r1[1], (int) r2[1])) // időeredmény szerinti rendezés
                .collect(Collectors.toList());
    }


    @PostMapping("/updateRace")
    public String updateRace(@RequestBody Verseny verseny) {
        try {
            Verseny existingVerseny = versenyRepository.findByAzonosito(verseny.getAzonosito())
                    .orElseThrow(() -> new IllegalArgumentException("Nem található verseny azonosítóval: " + verseny.getAzonosito()));

            existingVerseny.setNev(verseny.getNev());
            existingVerseny.setTavolsag(verseny.getTavolsag());

            versenyRepository.save(existingVerseny);

            return "Verseny frissítve sikeresen.";
        } catch (Exception e) {
            return "Hiba történt a verseny frissítése során: " + e.getMessage();
        }
    }


}
