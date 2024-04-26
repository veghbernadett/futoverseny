package hu.veghbernadett.futoverseny.controllers;

import hu.veghbernadett.futoverseny.domain.models.Verseny;
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
        return results;
    }

    //@PostMapping("/updateRace")
    @PutMapping("/updateRace")
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
